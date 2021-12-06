package com.example.reto.strategy.impl;

import com.example.reto.strategy.ExchangeStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DefaultExchangeStrategy implements ExchangeStrategy {
    public Double exchange(Double inputAmount, Double exchangeRate){
        BigDecimal vReturn =  BigDecimal.valueOf(inputAmount).multiply(BigDecimal.valueOf(exchangeRate));
        return vReturn.doubleValue();
    }
}
