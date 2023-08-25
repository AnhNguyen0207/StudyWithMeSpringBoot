package com.example.ex5_db_springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loai_danh_muc")
public class LoaiDanhMucEntity extends BaseEntity{
    @Column(name = "ma_loai_danh_muc",nullable = false)
    private String maLoaiDanhMuc;

    @Column(name = "ten",nullable = false)
    private String ten;

    @Column(name = "mo_ta",nullable = false)
    private String moTa;

    @OneToMany(mappedBy = "ma_loai_danh_muc")
    private List<SanPhamEntity> sanPhamEntities = new ArrayList<>();

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

    public List<SanPhamEntity> getSanPhamEntities() {
        return sanPhamEntities;
    }

    public void setSanPhamEntities(List<SanPhamEntity> sanPhamEntities) {
        this.sanPhamEntities = sanPhamEntities;
    }

}
