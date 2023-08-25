package com.sapo.edu.demo.service.impl;
import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.service.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("printFile")
public class PrinterFile implements Printer {
    Logger logger = LoggerFactory.getLogger(PrinterFile.class);
    @Override
    public void printCustomer(Customer customer) {
        logger.info("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        logger.info(message);
    }
}
