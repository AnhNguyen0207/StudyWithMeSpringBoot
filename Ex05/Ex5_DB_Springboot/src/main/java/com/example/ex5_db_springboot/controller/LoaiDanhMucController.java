package com.example.ex5_db_springboot.controller;


import com.example.ex5_db_springboot.model.LoaiDanhMuc;
import com.example.ex5_db_springboot.service.IBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class LoaiDanhMucController {

    private final IBase iLoaiDanhMuc;

    public LoaiDanhMucController(@Qualifier("LoaiDanhMuc") IBase iLoaiDanhMuc) {
        this.iLoaiDanhMuc = iLoaiDanhMuc;
    }

    Scanner sc = new Scanner(System.in);
    public List<LoaiDanhMuc> finAll()
    {
        return iLoaiDanhMuc.getAll();
    }
    public void create(LoaiDanhMuc loaiDanhMuc)
    {
        try {
            System.out.println("nhap ma loai danh muc");
            loaiDanhMuc.setMaLoaiDanhMuc(sc.next());
            System.out.println("nhap ten");
            loaiDanhMuc.setTen(sc.next());
            System.out.println("nhap mo ta");
            loaiDanhMuc.setMoTa(sc.next());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        iLoaiDanhMuc.create(loaiDanhMuc);
    }
}
