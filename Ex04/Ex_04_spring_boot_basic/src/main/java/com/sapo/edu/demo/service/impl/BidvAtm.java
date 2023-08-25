package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.model.Customer;
import com.sapo.edu.demo.service.Atm;
import com.sapo.edu.demo.service.Printer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class BidvAtm implements Atm {

    private final Printer printerConsole;
    private final Printer printerFile;
    private final MoneyAtm moneyAtm1;
    public BidvAtm(@Qualifier("printConsole") Printer printerConsole,
                   @Qualifier("printFile") Printer printerFile,
                    MoneyAtm moneyAtm1)
    {
        this.printerConsole = printerConsole;
        this.printerFile = printerFile;
        this.moneyAtm1 = moneyAtm1;
    }

    @Override
    public void withDraw(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) < 0) {
            printerConsole.printMessage("Amount is invalid");
            printerFile.printMessage("Amount is invalid");
            return;
        }
        if (customer.getBalance().compareTo(amount) < 0) {
            printerConsole.printMessage("Insufficient Balance");
            printerFile.printMessage("Insufficient Balance");
            return;
        }
        if (amount.compareTo(moneyAtm1.moneyAtm) >= 0) {
            printerConsole.printMessage("ATM is out of money");
            printerFile.printMessage("ATM is out of money");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.subtract(amount));
        moneyAtm1.moneyAtm = moneyAtm1.moneyAtm.subtract(amount);
    }

    @Override
    public void printCurrentMoney() {
        printerConsole.printMessage("Current ATM money is " + moneyAtm1.moneyAtm.toString());
        printerFile.printMessage("Current ATM money is " + moneyAtm1.moneyAtm.toString());
    }

    @Override
    public void deposit(Customer customer, BigDecimal amount) {
        if (amount == null || amount.compareTo(new BigDecimal(0)) <= 0) {
            printerConsole.printMessage("Amount is invalid");
            printerFile.printMessage("Amount is invalid");
            return;
        }

        BigDecimal currentBalance = customer.getBalance();
        customer.setBalance(currentBalance.add(amount));
        moneyAtm1.moneyAtm = moneyAtm1.moneyAtm.add(amount);
    }

    @Override
    public void displayCustomerInfo(Customer customer) {
        printerConsole.printCustomer(customer);
        printerFile.printCustomer(customer);
    }
}
