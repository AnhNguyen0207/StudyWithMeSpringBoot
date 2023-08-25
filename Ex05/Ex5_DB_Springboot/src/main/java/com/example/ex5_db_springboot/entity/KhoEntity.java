package com.example.ex5_db_springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kho")
public class KhoEntity extends BaseEntity {
    @Column(name = "ma_kho",nullable = false)
    private String maKho;

    @Column(name = "ten",nullable = false)
    private  String ten;

    @Column(name = "dia_diem",nullable = false)
    private String diaDiem;

    @OneToMany(mappedBy = "makho")
    private List<SanPhamEntity> sanPhamEntities = new ArrayList<>();

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public List<SanPhamEntity> getSanPhamEntities() {
        return sanPhamEntities;
    }

    public void setSanPhamEntities(List<SanPhamEntity> sanPhamEntities) {
        this.sanPhamEntities = sanPhamEntities;
    }

}
