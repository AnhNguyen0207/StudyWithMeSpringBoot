package com.example.ex5_db_springboot.controller;

import com.example.ex5_db_springboot.entity.KhoEntity;
import com.example.ex5_db_springboot.model.Kho;
import com.example.ex5_db_springboot.repository.KhoRepository;
import com.example.ex5_db_springboot.service.IBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Scanner;

@Controller
public class KhoController {

    private final KhoRepository khoRepository;
    private final IBase iKho;

    public KhoController(KhoRepository khoRepository, @Qualifier("Kho")IBase ikho)
    {
        this.khoRepository = khoRepository;
        this.iKho = ikho;
    }

    Scanner sc = new Scanner(System.in);

    public List<KhoEntity> findAll()
    {
        List<KhoEntity> khoEntities = khoRepository.findAll();
        return khoEntities;
    }

    public List<Kho> finAll()
    {
        return iKho.getAll();
    }


    public void create(Kho kho)
    {
        try{
            System.out.println("nhap ma kho");
            kho.setMaKho(sc.next());
            System.out.println("nhap ten");
            kho.setTen(sc.next());
            System.out.println("nhap ma dia diem");
            kho.setDiaDiem(sc.next());
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        iKho.create(kho);
    }

}
