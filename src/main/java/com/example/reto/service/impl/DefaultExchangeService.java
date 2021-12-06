package com.example.reto.service.impl;

import com.example.reto.converter.ExchangeRateConverter;
import com.example.reto.dto.ExchangeRateDto;
import com.example.reto.dto.ExchangeRequestDto;
import com.example.reto.dto.ExchangeResponseDto;
import com.example.reto.entity.Currency;
import com.example.reto.entity.ExchangeRateEntity;
import com.example.reto.entity.ExchangeRateTransactionEntity;
import com.example.reto.repository.ExchangeRateRepository;
import com.example.reto.service.ExchangeService;
import com.example.reto.strategy.ExchangeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultExchangeService implements ExchangeService {
    @Autowired
    private ExchangeStrategy exchangeStrategy;
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;
    @Autowired
    private ExchangeRateConverter exchangeRateConverter;

    public ExchangeResponseDto makeExchange(ExchangeRequestDto exchangeRequestDto){
        ExchangeResponseDto vReturn = new ExchangeResponseDto();
        Currency inputCurrency = Currency.valueOf(exchangeRequestDto.getOriginCurrency());
        Currency outputsCurrency = Currency.valueOf(exchangeRequestDto.getDestinationCurrency());
        if(inputCurrency == null){
            new RuntimeException("input currency es null");
        }
        if(outputsCurrency == null){
            new RuntimeException("output currency es null");
        }
        Optional<ExchangeRateEntity> opExchangeRateEntity = getExchangeRateEntityRepository()
                .findTopByOriginCurrencyAndDestinationCurrencyOrderByCreationDateDesc(inputCurrency,outputsCurrency);
        ExchangeRateEntity exchangeRateEntity = opExchangeRateEntity
                .orElseThrow(() -> new RuntimeException("No existe tipo de cambio"));
        Double amountExchanged = getExchangeStrategy()
                .exchange(exchangeRequestDto.getAmount(),exchangeRateEntity.getExchangeRate());

        vReturn.setDestinationCurrency(exchangeRequestDto.getDestinationCurrency());
        vReturn.setOriginCurrency(exchangeRequestDto.getOriginCurrency());
        vReturn.setAmount(exchangeRequestDto.getAmount());
        vReturn.setExchangeRate(exchangeRateEntity.getExchangeRate());
        vReturn.setAmountWithExchangeRate(amountExchanged);

        ExchangeRateTransactionEntity exchangeRateTransactionEntity = new ExchangeRateTransactionEntity();
        exchangeRateTransactionEntity.setDestinationCurrency(outputsCurrency);
        exchangeRateTransactionEntity.setOriginalCurrency(inputCurrency);
        exchangeRateTransactionEntity.setOriginalAmount(exchangeRequestDto.getAmount());
        exchangeRateTransactionEntity.setExchangeRate(vReturn.getExchangeRate());
        exchangeRateTransactionEntity.setDestinationAmount(vReturn.getAmountWithExchangeRate());
        exchangeRateTransactionEntity.setCreationDate(LocalDateTime.now());

        return vReturn;
    }

    @Override
    public List<ExchangeRateDto> findAll() {
        return getExchangeRateEntityRepository().findAll().stream().map(getExchangeRateConverter()::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ExchangeRateDto save(ExchangeRateDto input) {
        ExchangeRateEntity entity = getExchangeRateConverter().dtoToEntity(input);
        if (entity.getDestinationCurrency() == null){
            throw new RuntimeException("Sin moneda destino");
        }
        if (entity.getOriginCurrency() == null){
            throw new RuntimeException("Sin moneda origen");
        }
        entity = getExchangeRateEntityRepository().save(entity);
        entity.setCreationDate(LocalDateTime.now());
        return getExchangeRateConverter().entityToDto(entity);
    }


    public ExchangeStrategy getExchangeStrategy() {
        return exchangeStrategy;
    }
    @Autowired
    public void setExchangeStrategy(ExchangeStrategy exchangeStrategy) {
        this.exchangeStrategy = exchangeStrategy;
    }

    public ExchangeRateRepository getExchangeRateEntityRepository() {
        return exchangeRateRepository;
    }
    @Autowired
    public void setExchangeRateEntityRepository(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public ExchangeRateConverter getExchangeRateConverter() {
        return exchangeRateConverter;
    }
    @Autowired
    public void setExchangeRateConverter(ExchangeRateConverter exchangeRateConverter) {
        this.exchangeRateConverter = exchangeRateConverter;
    }
}
