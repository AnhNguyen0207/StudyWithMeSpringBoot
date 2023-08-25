package com.sapo.edu.demo.service.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@ConfigurationProperties(prefix = "my")
@Component
public class MoneyAtm {
    BigDecimal moneyAtm;

    public BigDecimal getMoneyAtm() {
        return moneyAtm;
    }

    public void setMoneyAtm(BigDecimal moneyAtm) {
        this.moneyAtm = moneyAtm;
    }
}
