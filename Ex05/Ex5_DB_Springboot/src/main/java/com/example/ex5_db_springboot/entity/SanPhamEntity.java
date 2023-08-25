package com.example.ex5_db_springboot.entity;

import com.example.ex5_db_springboot.model.SanPham;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "san_pham")
public class SanPhamEntity extends BaseEntity{
    @Column(name = "ma_san_pham",nullable = false)
    private String maSanPham;

    @ManyToOne
    @JoinColumn(name = "danh_muc", nullable = false)
    private  LoaiDanhMucEntity ma_loai_danh_muc;

    @ManyToOne
    @JoinColumn(name = "kho", nullable = false)
    private KhoEntity makho;

    @Column(name = "gia",nullable = false)
    private BigDecimal gia;

    @Column(name = "ten_mota_sp",nullable = false)
    private String tenMoTaSP;

    @Column(name = "duong_dan_anh")
    private String duongDanAnh;

    @Column(name = "so_luong_sp")
    private Long soLuongSP;

    @Column(name = "so_luong_ban")
    private Long soLuongBan;

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public LoaiDanhMucEntity getMa_loai_danh_muc() {
        return ma_loai_danh_muc;
    }

    public void setMa_loai_danh_muc(LoaiDanhMucEntity ma_loai_danh_muc) {
        this.ma_loai_danh_muc = ma_loai_danh_muc;
    }

    public KhoEntity getMakho() {
        return makho;
    }

    public void setMakho(KhoEntity makho) {
        this.makho = makho;
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
