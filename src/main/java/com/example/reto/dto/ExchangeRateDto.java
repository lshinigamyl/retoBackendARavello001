package com.example.reto.dto;

import com.example.reto.entity.Currency;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
public class ExchangeRateDto {

    private Currency originCurrency;

    private Currency destinationCurrency;

    private Double exchangeRate;

}
