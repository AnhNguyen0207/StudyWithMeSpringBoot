package com.example.ex2_maven_springboot;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Ex2MavenSpringBootApplication {
    static int aciton;
    public static void main(String[] args) {
//        SpringApplication.run(Ex2MavenSpringBootApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        display("nhap thong tin chuoi 1");
        String chuoi1 = scanner.nextLine();
        display("nhap thong tin chuoi 2");
        String chuoi2 = scanner.nextLine();
        display("\n");
        display("1.ket qua kiem tra xem chuoi 2 co nam trong chuoi 1 hay khong, bang containAny\n" +
                "2.ket qua kiem tra xem chuoi 2 co nam trong chuoi 1 hay khong co phan biet hoa thuong bang containsIgnoreCase\n" +
                "3.ket qua kiem tra xem co chuoi 2 xuat hien bao nhieu lan trong chuoi 1, bang countMatches0\n" +
                "4.noi chuoi 2 vao sau chuoi 1 bang appendIfMissing\n" +
                "5.noi chuoi 1 vao chuoi 2 bang prependIfMissing\n" +
                "6.chuyen kieu chu thuong thanh chu Hoa cho chuoi 1 bang upperCase\n" +
                "7.chuyen kieu chu thuong thanh chu Hoa cho chuoi 2 bang upperCase\n" +
                "8.chuyen kieu chu Hoa thanh chu thuong cho chuoi 1 bang lowerCase\n" +
                "9.chuyen kieu chu Hoa thanh chu thuong cho chuoi SS2 bang lowerCase\n" +
                "0.Exit\n");

        do
        {
            display("chon lua chon: ");
            aciton = scanner.nextInt();
        switch (aciton)
            {
            case 1:
                display("kq: " + StringUtils.containsAny(chuoi1, chuoi2));
                break;
            case 2:
                display("kq: " + StringUtils.containsIgnoreCase(chuoi1, chuoi2));
                break;
            case 3:
                display("kq: " + StringUtils.countMatches(chuoi1, chuoi2));
                break;
            case 4:
               display("kq: " + StringUtils.prependIfMissing(chuoi1, chuoi2));
                break;
            case 5:
                display("kq: " + StringUtils.appendIfMissing(chuoi1, chuoi2));
                break;
            case 6:
                display("kq: " + StringUtils.upperCase(chuoi1));
                break;
            case 7:
                display("kq: " + StringUtils.upperCase(chuoi2));
                break;
            case 8:
                display("kq: " + StringUtils.lowerCase(chuoi1));
                break;
            case 9:
                display("kq:  " + StringUtils.lowerCase(chuoi2));
                break;
            }
            display("\n");
        } while (aciton != 0);
    }
    public static void display(String msg)
    {
        System.out.println(msg);
    }
}


