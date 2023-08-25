import React from "react";

export type ContextProviderProps = {
    children: React.ReactNode
}

export type ContextValues = {
    category: {
        id: string,
        maLoaiDanhMuc: string;
        ten: string;
        moTa: string;
        ngayTao: string
        ngaySua: string
    };
    setCategory: Function;
    auth: {
        token: string
    };
    setAuth: Function
    username:string;
    setUserName:Function
}

export type PropsPagesDefault = {
    setCurPage: Function;
    curPage: number;
    totalPages: number
}

export type ResponeTypeUseToken = {
    data: { token: string }
}

export type TypeCategory = {
    id: number;
    maLoaiDanhMuc: string;
    ten: string;
    moTa: string;
    ngayTao:string;
    ngaySua:string
}

export type TypePropCategoty={
    category:{
      id: number;
      maLoaiDanhMuc: string;
      ten: string;
      moTa: string;
      ngayTao:string;
      ngaySua:string
    }
  }





