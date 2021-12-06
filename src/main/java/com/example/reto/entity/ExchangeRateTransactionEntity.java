package com.example.reto.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exchange_rate_transactions")
@Setter
@Getter
public class ExchangeRateTransactionEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "original_currency")
    private Currency originalCurrency;

    @Column(name = "original_amount")
    private Double originalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_currency")
    private Currency destinationCurrency;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "destination_amount")
    private Double destinationAmount;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
