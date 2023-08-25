package com.sapo.edu.demo.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;
@Component
public class Customer {
    private String acctNo;
    private String pin;
    private BigDecimal balance;

    public Customer(String accountNo,String pin,BigDecimal balance) {
        this.acctNo = accountNo;
        this.pin = pin;
        this.balance = balance;
    }
    public Customer()
    {}

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void createCustomer()
    {
         Scanner sc = new Scanner(System.in);
         System.out.print("Nhap ID: ");
         acctNo = sc.nextLine();
         System.out.print("Nhap ma pin: ");
         pin = sc.nextLine();
         System.out.print("Nhap so tien khoi tao: ");
         balance = sc.nextBigDecimal();

         System.out.println("Hien thi Customer vua nhap");
         System.out.println("ID: "+ acctNo);
         System.out.println("Pin: "+ pin);
         System.out.println("Balance: "+ balance);
    }

}
