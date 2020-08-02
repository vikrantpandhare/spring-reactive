package com.example.springreactive.springreactive.resource;

import com.example.springreactive.springreactive.entity.WeatherEntity;
import com.example.springreactive.springreactive.model.Weather;
import com.example.springreactive.springreactive.repository.DataRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
public class ApplicationDataResource {

    private final DataRepository dataRepository;

    public ApplicationDataResource(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @PostMapping("/save")
    public Mono<WeatherEntity> saveData(@RequestBody Weather weather) {
        return dataRepository.save(new WeatherEntity()
                                           .setHumidity(weather.getHumidity())
                                           .setTemperature(weather.getTemperature()));

    }
}
