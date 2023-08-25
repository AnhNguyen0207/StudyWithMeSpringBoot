import React, { useContext} from "react";
import "../styles/Login.css";
import { useNavigate } from "react-router-dom";
import { Context } from "../context/Context";
import { axiosCall, getConfig } from "../api/axiosApi";
import { ResponeTypeUseToken } from "../BaseTs";
import { useForm } from "react-hook-form";
import {loginSuccess} from "../redux/AuthSlide"
import { RootState } from "../redux/Store";
import { useDispatch, useSelector } from "react-redux";


type DataSubmit = {
  username: string;
  password: string;
}

function Login() {
  const token = useSelector((state:RootState) => state.auths.token)
  const dispatch = useDispatch();
  const useNameContext = useContext(Context);
  const redirect = useNavigate();
  const auth = useContext(Context);
  const { register, handleSubmit, formState: { errors } } = useForm<DataSubmit>();

  const handleLogin = (userName: string, passWord: string) => {
    const path = "/login";
    const method = "post";
    const data = {
      username: userName,
      password: passWord,
    };
    const token = null;
    const msgError = "username/password không đúng!";
    const config = getConfig(method, path, data, token);
    axiosCall(config, afterCallApi, msgError);
  };

  const afterCallApi = (respone: ResponeTypeUseToken) => {
    localStorage.setItem("token", respone.data.token);
    auth.setAuth({ token: localStorage.getItem("token") });
    dispatch((loginSuccess(localStorage.getItem("token"))));
    alert("Đăng nhập thành công!");
    redirect("/dash-board/categories");
  };


  const onSubmit = (respone: DataSubmit) => {
    const userName = respone.username;
    const passWord = respone.password;
    useNameContext.setUserName(userName);
    handleLogin(userName, passWord);
  }

  return (
    <div className="login">
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="label-login">
          <label>Đăng Nhập</label>
        </div>
        <div className="label" >
          <label htmlFor="userName"><b>UserName</b></label>
        </div>
        <div className="login-input">
          <input
            id="userName"
            type="text"
            {...register("username", { required: true, minLength: 5 })}
          />
        </div>
        {errors.username?.type === "required" && <p>UserName is requirerd</p>}
        {errors.username?.type === "minLength" && <p>UserName must be 5 charaters long</p>}

        <div className="label">
          <label htmlFor="passWord"><b>PassWord</b></label>
        </div>
        <div className="login-input">
          <input
            id="passWord"
            type="password"
            {...register("password", { required: true, minLength: 5 })}
          />
        </div>

        {errors.password?.type === "required" && <p>PassWord is requirerd</p>}
        {errors.password?.type === "minLength" && <p>PassWord must be 5 charaters long</p>}

        <div className="login-input">
          <button type="submit" name="button-submit">
            Submit
          </button>
        </div>
      </form >
    </div>
  );
}

export default Login;
