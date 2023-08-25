import { axiosCall, getConfig } from "../../api/axiosApi";
import React, {useContext } from "react";
import { Context } from "../../context/Context";
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";

type DataSubmit = {
  maLoai: string;
  ten: string;
  moTa: string
}

function UpdateCategory() {
  const context = useContext(Context);
  const categoryDetail = context.category;
  const { register, handleSubmit, formState: { errors } } = useForm<DataSubmit>();
  const redirect = useNavigate();

  const handleUpdate = (maLoai: string, ten: string, moTa: string) => {
    const path = `/category/${categoryDetail.id}`;
    const method = "put";
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
    handleUpdate(maLoai, ten, moTa);
  }

  const afterCallApi = () => {
    alert("sửa thành công!");
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
                value={categoryDetail.maLoaiDanhMuc}
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
                placeholder={categoryDetail.ten}
              />
              {errors.ten?.type === "required" && <p>Không được để trống</p>}
            </td>
          </tr>
          <tr>
            <td><b>Mô Tả:</b></td>
            <td>
              <input
                type="text"
                placeholder={categoryDetail.moTa}
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
export default UpdateCategory;
