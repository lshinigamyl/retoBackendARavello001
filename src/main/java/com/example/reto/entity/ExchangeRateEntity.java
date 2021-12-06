package com.example.reto.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "exchange_rate")
@Entity
public class ExchangeRateEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin_currency")
    private Currency originCurrency;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_currency")
    private Currency destinationCurrency;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}