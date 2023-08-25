import React, { useContext } from "react";
import { Context } from "../../context/Context";
import { useNavigate } from "react-router-dom";
import { axiosCall, getConfig } from "../../api/axiosApi";
import { stringify } from "querystring";

function CategoryDetail() {
  const context = useContext(Context);
  const categoryDetail = context.category;
  const redirect = useNavigate();

  const deleteCategory = () => {
    const path = `/category/delete/${categoryDetail.id}`;
    const method = "delete";
    const data = {};
    const token = localStorage.getItem("token");
    const msgError = "xoá không thành công!";
    const config = getConfig(method, path, data, token);
    axiosCall(config, afterCallApi, msgError);
  };

  const afterCallApi = () => {
    alert("Xoá thành công!");
    redirect("/dash-board/categories");
  };

  return (
    <>
      <div className="category-detail">
        <p>
          <b>mã loại:</b> {categoryDetail.maLoaiDanhMuc}
        </p>
        <p>
          <b>tên:</b> {categoryDetail.ten}
        </p>
        <p>
          <b>mô tả:</b> {categoryDetail.moTa}
        </p>
        <p>
          <b>ngày tạo:</b> {categoryDetail.ngayTao}
        </p>
        <p>
          <b>ngày sửa:</b> {categoryDetail.ngaySua}
        </p>
      </div>
      <div className="button-category">
        <button
          onClick={() => {
            redirect("/dash-board/categories");
          }}
        >
          Quay Lại
        </button>
        <button onClick={deleteCategory}>Xoá</button>
        <button
          onClick={() => {
            redirect("/dash-board/update-category");
          }}
        >
          Sửa
        </button>
      </div>
    </>
  );
}
export default CategoryDetail;
