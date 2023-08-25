package com.example.ex09_producer.entity;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Timestamp;

@Entity
@Table(name = "tong_sl_sp_kho")
public class TongSlSpKho {
    @Id
    @Valid
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Valid
    @Column(name = "ma_kho_sp", nullable = false, length = 20)
    private String maKhoSp;

    @Valid
    @Column(name = "sl_sp_kho")
    private Integer slSpKho;

    @Valid
    @Column(name = "ngay_thong_ke")
    private Timestamp ngayThongKe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaKhoSp() {
        return maKhoSp;
    }

    public void setMaKhoSp(String maKhoSp) {
        this.maKhoSp = maKhoSp;
    }

    public Integer getSlSpKho() {
        return slSpKho;
    }

    public void setSlSpKho(Integer slSpKho) {
        this.slSpKho = slSpKho;
    }

    public Timestamp getNgayThongKe() {
        return ngayThongKe;
    }

    public void setNgayThongKe(Timestamp ngayThongKe) {
        this.ngayThongKe = ngayThongKe;
    }

}