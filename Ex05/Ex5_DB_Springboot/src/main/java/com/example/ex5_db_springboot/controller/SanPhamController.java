package com.example.ex5_db_springboot.controller;

import com.example.ex5_db_springboot.model.SanPham;
import com.example.ex5_db_springboot.service.IBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class SanPhamController {

    private final IBase iSanPham;

    public SanPhamController(@Qualifier("SanPham") IBase iSanPham) {
        this.iSanPham = iSanPham;
    }

    public List<SanPham> finAll()
    {
        return iSanPham.getAll();
    }
}
