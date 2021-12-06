package com.example.reto.converter;

import com.example.reto.dto.ExchangeRateDto;
import com.example.reto.entity.ExchangeRateEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRateConverter {
    private ModelMapper modelMapper;

    public ExchangeRateDto entityToDto(ExchangeRateEntity input){
        return getModelMapper().map(input, ExchangeRateDto.class);
    }

    public ExchangeRateEntity dtoToEntity(ExchangeRateDto input){
        return getModelMapper().map(input, ExchangeRateEntity.class);
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
