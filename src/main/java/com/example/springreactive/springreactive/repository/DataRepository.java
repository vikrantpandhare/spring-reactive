package com.example.springreactive.springreactive.repository;

import com.example.springreactive.springreactive.entity.WeatherEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DataRepository extends ReactiveMongoRepository<WeatherEntity, String> {

}
