package com.example.reto.controller.impl;

import com.example.reto.controller.ExchangeRateController;
import com.example.reto.controller.ExchangeRateTransactionController;
import com.example.reto.dto.ExchangeRequestDto;
import com.example.reto.dto.ExchangeResponseDto;
import com.example.reto.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exchangeRateTransaction")
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
public class DefaultExchangeRateTransactionController implements ExchangeRateTransactionController {

    private ExchangeService exchangeService;

    @PostMapping(produces = "application/json",consumes = "application/json")
    public ExchangeResponseDto create(
            @RequestBody ExchangeRequestDto requestDto
    ) {
        return getExchangeService().makeExchange(requestDto);
    }

    public ExchangeService getExchangeService() {
        return exchangeService;
    }

    @Autowired
    public void setExchangeService(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
}
