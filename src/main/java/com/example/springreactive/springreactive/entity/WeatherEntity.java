package com.example.springreactive.springreactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class WeatherEntity {

    @Id
    private String id;

    private BigDecimal temperature;

    private BigDecimal humidity;

    public BigDecimal getTemperature() {
        return temperature;
    }

    public WeatherEntity setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public WeatherEntity setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
        return this;
    }
}
