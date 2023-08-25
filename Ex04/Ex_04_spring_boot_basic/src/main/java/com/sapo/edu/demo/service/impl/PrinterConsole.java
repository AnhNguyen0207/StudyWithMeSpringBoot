package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.service.Printer;
import org.springframework.stereotype.Component;

@Component("printConsole")
public class PrinterConsole implements Printer {

    @Override
    public void printCustomer(Customer customer) {
        System.out.println("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }


}
