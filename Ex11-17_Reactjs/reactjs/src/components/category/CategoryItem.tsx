import React, { useContext } from "react";
import { Context } from "../../context/Context";
import "../../styles/Category.css";
import { useNavigate } from "react-router-dom";
import { TypePropCategoty } from "../../BaseTs"



function CategoryItem({ category }: TypePropCategoty) {
  const context = useContext(Context);
  const redirect = useNavigate();

  const click = () => {
    context.setCategory(category);
    localStorage.setItem("category", JSON.stringify(category));
    redirect("/dash-board/category-detail");
  };

  return (
    <>
      <tbody>
        <tr>
          <td onClick={click}>{category.maLoaiDanhMuc}</td>
          <td onClick={click}>{category.ten}</td>
        </tr>
      </tbody>
    </>
  );
}
export default CategoryItem;
