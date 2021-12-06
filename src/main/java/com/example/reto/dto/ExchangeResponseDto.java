package com.example.reto.dto;

import lombok.Data;

@Data
public class ExchangeResponseDto {
    private String originCurrency;
    private Double amount;
    private String destinationCurrency;
    private Double exchangeRate;
    private Double amountWithExchangeRate;
}
