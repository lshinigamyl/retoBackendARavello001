package com.example.reto.dto;


import lombok.Data;

@Data
public class ExchangeRequestDto {
    private String originCurrency;
    private Double amount;
    private String destinationCurrency;
}
