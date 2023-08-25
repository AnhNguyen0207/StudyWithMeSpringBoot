import React from "react";
import { Outlet } from "react-router-dom";
import "../styles/DashBoard.css";
import Navigation from "./Navigation";

function DashBoard() {
  return (
    <>
      <Navigation />
      <div style={{height:"20px"}}></div>
      <Outlet></Outlet>
    </>
  );
}
export default DashBoard;
