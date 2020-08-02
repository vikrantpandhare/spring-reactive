package com.example.springreactive.springreactive.model;

import java.math.BigDecimal;

public class Weather {

    BigDecimal temperature;

    BigDecimal humidity;

    public BigDecimal getTemperature() {
        return temperature;
    }

    public Weather setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
        return this;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public Weather setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
        return this;
    }
}
