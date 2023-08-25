import React, { useEffect, useState } from "react";
import CategoryItem from "./CategoryItem";
import { useNavigate } from "react-router-dom";
import Paging from "../Paging";
import { axiosCall, getConfig } from "../../api/axiosApi";
import { TypeCategory } from "../../BaseTs"


function CategoryList() {
    const [categories, setCategories] = useState<[]>([]);
    const [page, setPage] = useState<number>(1);
    const limit = 5;
    const redirect = useNavigate();
    const [totalpages, setTotalPages] = useState<number>(0);

    useEffect(
      function apiGetCategories() {
        const path = `/categories?page=${page}&limit=${limit}`;
        const method = "get";
        const data = {};
        const msgError = "không lấy được data";
        const token = null
        const config = getConfig(method, path, data, token);
        axiosCall(config, afterCallApi, msgError);
      },[page]
    );

    useEffect(function apiGetTotalCategory() {
      const path = "/total-item";
      const method = "get";
      const data = {};
      const msgError = "không lấy được total Categotry";
      const config = getConfig(method, path, data, null);
      axiosCall(config, afterCallApi1, msgError);
    }, []);

    type ResponeTypePagesCategory = {
      data: []
    }
    const afterCallApi = (respone: ResponeTypePagesCategory) => {
      setCategories(respone.data);
    };

    type ResponeTypeToTalCategory = {
      data: number
    }
    const afterCallApi1 = (respone: ResponeTypeToTalCategory) => {
      setTotalPages(Math.ceil(respone.data / limit));
    };

    const setCurPage = (number: number) => {
      setPage(number);
    };

    return (
      <>
      
        <div className="category-list">
          <table>
            <thead>
              <tr>
              <th>CategoyId</th>
              <th>Name</th>
              </tr>
            </thead>
              {categories.map((category: TypeCategory) => (
            <CategoryItem key={category.id} category={category} />
          ))}
            
          </table>
        </div>
        <Paging setCurPage={setCurPage} curPage={page} totalPages={totalpages} />
        <div className="category-list">
          <div className="button">
            <button
              onClick={() => {
                redirect("/dash-board/create-category");
              }}
            >
              Thêm
            </button>
          </div>{" "}
        </div>
      </>
    );
  }
export default CategoryList;
