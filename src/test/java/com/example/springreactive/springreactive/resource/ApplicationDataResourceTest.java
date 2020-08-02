package com.example.springreactive.springreactive.resource;

import com.example.springreactive.springreactive.entity.WeatherEntity;
import com.example.springreactive.springreactive.model.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureWebTestClient
class ApplicationDataResourceTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void saveData_shouldSuccess_whenValidData() {
        webTestClient.post()
                     .uri("/reactive/save")
                     .contentType(MediaType.APPLICATION_JSON)
                     .bodyValue(new Weather()
                                        .setHumidity(BigDecimal.valueOf(10))
                                        .setTemperature(BigDecimal.valueOf(20)))
                     .exchange()
                     .expectStatus()
                     .isOk()
                     .expectBody(WeatherEntity.class)
                     .consumeWith(t -> {
                         assertThat(t.getResponseBody()).isNotNull();
                         assertThat(t.getResponseBody().getHumidity()).isNotNull();
                         assertThat(t.getResponseBody().getTemperature()).isNotNull();
                     });

    }

}
