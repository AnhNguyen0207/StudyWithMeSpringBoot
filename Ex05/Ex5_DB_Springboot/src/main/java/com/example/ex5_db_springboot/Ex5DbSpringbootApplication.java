package com.example.ex5_db_springboot;

import com.example.ex5_db_springboot.controller.KhoController;
import com.example.ex5_db_springboot.controller.LoaiDanhMucController;
import com.example.ex5_db_springboot.controller.SanPhamController;
import com.example.ex5_db_springboot.entity.KhoEntity;
import com.example.ex5_db_springboot.model.Kho;
import com.example.ex5_db_springboot.model.LoaiDanhMuc;
import com.example.ex5_db_springboot.model.SanPham;
import com.example.ex5_db_springboot.service.impl.IKho;
import com.example.ex5_db_springboot.service.impl.ILoaiDanhMuc;
import com.example.ex5_db_springboot.service.impl.ISanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Ex5DbSpringbootApplication implements CommandLineRunner {

            private KhoController khoController;
            private LoaiDanhMucController loaiDanhMucController;
            private SanPhamController sanPhamController;

    public Ex5DbSpringbootApplication(KhoController khoController, LoaiDanhMucController loaiDanhMucController, SanPhamController sanPhamController) {
        this.khoController = khoController;
        this.loaiDanhMucController = loaiDanhMucController;
        this.sanPhamController = sanPhamController;
    }

    Scanner sc = new Scanner(System.in);
    KhoEntity khoEntity = new KhoEntity();
     int action;
    public static void main(String[] args) {
        SpringApplication.run(Ex5DbSpringbootApplication.class, args);
        }
    @Override
    public void run(String... args) throws Exception {
       showMessage("--------------------------\n"+
                "1. Hien thi danh sach kho\n" +
                "2. Hien thi danh sach loai danh muc\n" +
                "3. Hien thi danh sach san pham\n" +
                "4. Them kho\n" +
                "5. Them loai danh muc\n" +
                "0.Exit\n" +
                "--------------------------");

        do {
            System.out.println();
            System.out.print("Nhap lua chon: ");
            action = sc.nextInt();
            System.out.println();
            switch(action)
            {
                case 1:
                    for (Kho item:khoController.finAll())
                    {
                       showMessage(item.getId()+", "+item.getTen()+" "+item.getMaKho()+", "+item.getDiaDiem()+", "+item.getNgayTao()+", "+item.getNgaySua());
                    }
                    break;
                case 2:

                    for (LoaiDanhMuc item:loaiDanhMucController.finAll())
                    {
                        showMessage(item.getId()+", "+item.getTen()+", "+item.getMaLoaiDanhMuc()+", "+item.getMoTa()+", "+item.getNgayTao()+", "+item.getNgaySua());
                    }
                    break;
                case 3:

                    for (SanPham item:sanPhamController.finAll())
                    {
                        showMessage(item.getId()+", "+item.getDanhMuc()+", "+item.getKho()+", "+item.getMaSanPham()+", "+item.getGia()+", "+item.getDuongDanAnh()+", "+item.getTenMoTaSP()+", "+item.getSoLuongSP()+", "+item.getSoLuongBan()+", "+item.getNgayTao()+", "+item.getNgaySua());
                    }
                    break;
                case 4:
                    Kho kho = new Kho();
                    khoController.create(kho);
                    showMessage("them thanh cong");
                    break;
                case 5:
                    LoaiDanhMuc loaiDanhMuc = new LoaiDanhMuc();
                    loaiDanhMucController.create(loaiDanhMuc);
                    showMessage("them thanh cong");
                    break;
//                case 6:
//
////                    for (KhoEntity item: khoController.findAll()) {
////                        showMessage(item.getId() + ", " + item.getTen() + " " + item.getMaKho() + ", " + item.getDiaDiem() + ", " + item.getNgayTao() + ", " + item.getNgaySua());
////                    }
//                    break;
            }

        }while (action != 0);

    }
    public void showMessage(String msg)
    {
        System.out.println(msg);
    }
}
