import React, { useContext, memo } from "react";
import "../styles/Navigation.css";
import { useNavigate } from "react-router-dom";
import { Context } from "../context/Context";
import useAuth from "../auth/useAuth";
function Navigation() {
  const logOut = useNavigate();
  const { auth, setAuth } = useAuth();
  const useNameContext = useContext(Context);
  localStorage.setItem("username",(useNameContext.username));

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("category");
    setAuth(null);
    logOut("/login");
  };
  return (
    <>
      <div className="navigation">
        <div className="navigation-text">
        Xin chào {useNameContext.username}
        </div>
        <div className="navigation-button">
          <button onClick={handleLogout}>Đăng Xuất</button>
        </div>
      </div>
    </>
  );
}
export default memo(Navigation);
