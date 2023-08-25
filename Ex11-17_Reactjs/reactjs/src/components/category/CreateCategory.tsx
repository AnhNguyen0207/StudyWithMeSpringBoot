import { axiosCall, getConfig } from "../../api/axiosApi";
import React from "react";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";

type DataSubmit = {
  maLoai: string;
  ten: string;
  moTa: string
}

function CreateCategory() {
  const redirect = useNavigate();
  const { register, handleSubmit, formState: { errors } } = useForm<DataSubmit>();
  const handleCreate = (maLoai: string, ten: string, moTa: string) => {
    const path = "/category";
    const method = "post";
    const data = {
      maLoaiDanhMuc: maLoai,
      ten: ten,
      moTa: moTa,
    };
    const token = localStorage.getItem("token");
    const msgError = "không được để trống thông tin!";
    const config = getConfig(method, path, data, token);
    axiosCall(config, afterCallApi, msgError);
  };

  const onSubmit = (respone: DataSubmit) => {
    const maLoai = respone.maLoai;
    const ten = respone.ten;
    const moTa = respone.moTa
    handleCreate(maLoai, ten, moTa);
  }

  const afterCallApi = () => {
    alert("thêm thành công!");
    redirect("/dash-board/categories");
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <div className="create-update-category">
        <table>
          <tbody>
          <tr>
            <td><b>Mã Loại</b>:</td>
            <td>
              <input
                type="text"
                {...register("maLoai", { required: true })}
              />
              {errors.maLoai?.type === "required" && <p>Không được để trống</p>}
            </td>
          </tr>
          <tr>
            <td><b>Tên:</b></td>
            <td>
              <input
                type="text"
                {...register("ten", { required: true})}
              />
              {errors.ten?.type === "required" && <p>Không được để trống</p>}
            </td>
          </tr>
          <tr>
            <td><b>Mô Tả:</b></td>
            <td>
              <input
                type="text"
                {...register("moTa", { required: true })}
              />
              {errors.moTa?.type === "required" && <p>Không được để trống</p>}
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div className="button-category">
        <button type="submit">Lưu</button>
        <button
          onClick={() => {
            redirect("/dash-board/categories");
          }}
        >
          Quay Lại
        </button>
      </div>
    </form>
  );
}
export default CreateCategory;
