package com.example.reto.service;

import com.example.reto.dto.ExchangeRateDto;
import com.example.reto.dto.ExchangeRequestDto;
import com.example.reto.dto.ExchangeResponseDto;

import java.util.List;

public interface ExchangeService {
    ExchangeResponseDto makeExchange(ExchangeRequestDto exchangeRequestDto);
    List<ExchangeRateDto> findAll();
    ExchangeRateDto save(ExchangeRateDto input);
}
