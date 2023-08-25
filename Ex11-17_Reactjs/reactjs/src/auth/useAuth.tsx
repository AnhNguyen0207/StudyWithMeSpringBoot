import { useContext } from "react";
import { Context } from "../context/Context";

function useAuth() {
  return useContext(Context);
}
export default useAuth;
