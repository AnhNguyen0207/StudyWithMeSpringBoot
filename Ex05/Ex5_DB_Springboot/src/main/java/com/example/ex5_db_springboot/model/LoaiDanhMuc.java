package com.example.ex5_db_springboot.model;

public class LoaiDanhMuc extends BaseTable {
    private String maLoaiDanhMuc;
    private String ten;
    private String moTa;

    public String getMaLoaiDanhMuc() {
        return maLoaiDanhMuc;
    }

    public void setMaLoaiDanhMuc(String maLoaiDanhMuc) {
        this.maLoaiDanhMuc = maLoaiDanhMuc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
