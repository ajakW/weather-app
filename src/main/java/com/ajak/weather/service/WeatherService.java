package com.ajak.weather.service;

import com.ajak.weather.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    @Autowired
    private RedisService redisService;

    @Value("${weather.api.key}")
    private String apiKey;

    private final WebClient client = WebClient.create("https://api.openweathermap.org/data/2.5");

    public Mono<String> getWeatherForCity(String city) {
        String cached = redisService.get(city);
        if (cached != null) {
            return Mono.just(cached);
        }

        return client.get()
                .uri("/weather?q=" + city + "&appid=" + apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response -> redisService.set(city, response, 900));
    }
}
