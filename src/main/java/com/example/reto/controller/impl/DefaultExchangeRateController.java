package com.example.reto.controller.impl;

import com.example.reto.controller.ExchangeRateController;
import com.example.reto.dto.ExchangeRateDto;
import com.example.reto.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/exchangeRate")
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
public class DefaultExchangeRateController implements ExchangeRateController {
    private ExchangeService exchangeService;

    @GetMapping(produces = "application/json")
    public List<ExchangeRateDto> getExchanges() {
        return getExchangeService().findAll();
    }

    @PostMapping( produces = "application/json")
    public ExchangeRateDto save(
            @RequestBody ExchangeRateDto body
    ){
        return getExchangeService().save(body);
    }

    public ExchangeService getExchangeService() {
        return exchangeService;
    }

    @Autowired
    public void setExchangeService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
}
