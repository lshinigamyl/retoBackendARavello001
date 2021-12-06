package com.example.reto.repository;

import com.example.reto.entity.Currency;
import com.example.reto.entity.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, UUID> {
    Optional<ExchangeRateEntity> findTopByOriginCurrencyAndDestinationCurrencyOrderByCreationDateDesc(Currency originalCurrency, Currency destinationCurrency);
}