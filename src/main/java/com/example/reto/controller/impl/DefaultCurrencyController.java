package com.example.reto.controller.impl;

import com.example.reto.controller.CurrencyController;
import com.example.reto.converter.CurrencyConverter;
import com.example.reto.dto.CurrencyDto;
import com.example.reto.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/currency")
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
public class DefaultCurrencyController implements CurrencyController {

    private CurrencyConverter currencyConverter;

    @GetMapping(produces = "application/json")
    public List<CurrencyDto> getCurrencies() {
        return Arrays.stream(Currency.values()).map(getCurrencyConverter()::enumToDto) .collect(Collectors.toList());
    }

    public CurrencyConverter getCurrencyConverter() {
        return currencyConverter;
    }

    @Autowired
    public void setCurrencyConverter(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }
}
