# Weather App

A simple weather application built with **Java (Spring Boot)** for the backend, **Redis** for caching, and a **vanilla HTML/CSS/JS** frontend.  
It fetches real-time weather data from [OpenWeatherMap](https://openweathermap.org/api) and displays it to the user.


## Features
- Search weather by city name
- Live API integration with OpenWeatherMap
- Redis caching layer (faster responses, reduces API calls)
- Simple frontend (no build tools)
- Docker support for Redis
- Local + GitHub deploy ready


## Tech Stack
- **Backend**: Java 17, Spring Boot, Maven
- **Cache**: Redis (via Docker)
- **Frontend**: HTML, CSS, JavaScript
- **API**: OpenWeatherMap


## Setup & Run (Local)
Running the weather-app
-first open docker
In the terminal:
docker-compose up -d
mvn spring-boot:run

An example on postman
-http://localhost:8080/weather?city=Nairobi   in postman
<img width="953" height="189" alt="image" src="https://github.com/user-attachments/assets/1577cc1a-48b0-450d-b1e5-7ced31951fd2" />


