package com.example.reto.controller;

import com.example.reto.dto.ExchangeRateDto;
import com.example.reto.dto.ExchangeRequestDto;
import com.example.reto.dto.ExchangeResponseDto;

import java.util.List;

public interface ExchangeRateTransactionController {
    ExchangeResponseDto create(ExchangeRequestDto requestDto);
}
