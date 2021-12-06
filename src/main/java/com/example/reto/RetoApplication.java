package com.example.reto;

import com.example.reto.entity.Currency;
import com.example.reto.entity.ExchangeRateEntity;
import com.example.reto.repository.ExchangeRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RetoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ExchangeRateRepository exchangeRateRepository) {
        return (args) -> {
            ExchangeRateEntity exchangeRateEntity01 = new ExchangeRateEntity();
            exchangeRateEntity01.setOriginCurrency(Currency.PEN);
            exchangeRateEntity01.setDestinationCurrency(Currency.USD);
            exchangeRateEntity01.setExchangeRate(1/4.1015);
            exchangeRateRepository.save(exchangeRateEntity01);
            ExchangeRateEntity exchangeRateEntity02 = new ExchangeRateEntity();
            exchangeRateEntity02.setOriginCurrency(Currency.USD);
            exchangeRateEntity02.setDestinationCurrency(Currency.PEN);
            exchangeRateEntity02.setExchangeRate(4.1010);
            exchangeRateRepository.save(exchangeRateEntity02);
        };
    }
}
