package com.ajak.weather.controller;

import com.ajak.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public Mono<String> getWeather(@RequestParam("city") String city) {
        return weatherService.getWeatherForCity(city);
    }
}
