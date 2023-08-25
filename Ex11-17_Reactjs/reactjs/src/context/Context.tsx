import { useState, createContext } from "react";
import { ContextProviderProps } from "../BaseTs"
import { ContextValues } from "../BaseTs"

const ContextDefault: ContextValues = {
  category: {
    id: '',
    maLoaiDanhMuc: '',
    ten: '',
    moTa: '',
    ngayTao: '',
    ngaySua: ''
  },
  setCategory: () => { },
  auth: {
    token: ''
  },
  setAuth: () => { },
  username:'',
  setUserName: ()=>{}
}

const Context = createContext<ContextValues>(ContextDefault);
function ContextProvider({ children }: ContextProviderProps) {
  const categoryLocal = localStorage.getItem('category');
  const categoryDetail = JSON.parse(categoryLocal?categoryLocal:"null")
  const userNameLocal = localStorage.getItem("username");
  
  const [category, setCategory] = useState<Object | any>(categoryDetail);
  const [auth, setAuth] = useState<Object | any>({token: localStorage.getItem("token")});
  const [username,setUserName] = useState<string | any>(userNameLocal);
  return (
    <Context.Provider value={{ category, setCategory, auth, setAuth, username,setUserName}}>
      {children}
    </Context.Provider >
  );
}
export { Context, ContextProvider };
