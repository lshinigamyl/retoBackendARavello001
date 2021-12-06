package com.example.reto.converter;

import com.example.reto.dto.CurrencyDto;
import com.example.reto.entity.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConverter {

    public CurrencyDto enumToDto(Currency currency){
        CurrencyDto vReturn = new CurrencyDto();
        vReturn.setCode(currency.name());
        vReturn.setDescription(currency.getDescription());
        return vReturn;
    }
}
