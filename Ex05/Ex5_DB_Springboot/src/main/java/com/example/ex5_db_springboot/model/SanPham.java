package com.example.ex5_db_springboot.model;

import java.math.BigDecimal;

public class SanPham extends BaseTable {
    private String maSanPham;
    private String danhMuc;
    private String kho;
    private BigDecimal gia;
    private String tenMoTaSP;
    private String duongDanAnh;
    private Long soLuongSP;
    private Long soLuongBan;

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getKho() {
        return kho;
    }

    public void setKho(String kho) {
        this.kho = kho;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getTenMoTaSP() {
        return tenMoTaSP;
    }

    public void setTenMoTaSP(String tenMoTaSP) {
        this.tenMoTaSP = tenMoTaSP;
    }

    public String getDuongDanAnh() {
        return duongDanAnh;
    }

    public void setDuongDanAnh(String duongDanAnh) {
        this.duongDanAnh = duongDanAnh;
    }

    public Long getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(Long soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public Long getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(Long soLuongBan) {
        this.soLuongBan = soLuongBan;
    }
}
