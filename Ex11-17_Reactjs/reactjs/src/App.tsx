import "./App.css";
import Login from "./components/Login";
import DashBoard from "./components/Dashboard";
import { Route, Routes } from "react-router-dom";
import CategoryDetail from "./components/category/CategoryDetail";
import CategoryList from "./components/category/CategoryList";
import CreateCategory from "./components/category/CreateCategory";
import UpdateCategory from "./components/category/UpdateCategory";
import RequireAuth from "./auth/RequireAuth";

function App() {
  return (
    <>
      <Routes>
        <Route element={<RequireAuth />}>
          <Route path="/" />
          <Route path="/dash-board" element={<DashBoard />}>
            <Route path="/dash-board/categories" element={<CategoryList />}></Route>
            <Route path="/dash-board/category-detail" element={<CategoryDetail />}></Route>
            <Route path="/dash-board/create-category" element={<CreateCategory />}></Route>
            <Route path="/dash-board/update-category" element={<UpdateCategory />}></Route>
          </Route>
        </Route>
        <Route path="/login" element={<Login />}></Route>
      </Routes>
    </>
  );
}

export default App;
