import axios from "axios";

const base = `http://localhost:8080/admin`;


function getConfig(method:string, path:string, data:object, token:string | any){
  const body  = JSON.stringify(data);

  const config = {
    method: method,
    url: base + path,
    headers: {
      "Content-Type": "application/json",
      Authorization: token ? "Bearer " + token : "",
    },
    data: body,
  };
  return config;
};

const axiosCall = (config:object, callBack:Function, msgError:string) => {
  axios(config)
    .then(function (response) {
      callBack(response);
    })
    .catch(function (error) {
      alert(msgError);
    });
};

export { getConfig, axiosCall };
