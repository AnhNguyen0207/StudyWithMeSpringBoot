package com.sapo.edu.demo.service;

import com.sapo.edu.demo.model.Customer;

public interface Printer {
    void printCustomer(Customer customer);

    void printMessage(String message);
}
