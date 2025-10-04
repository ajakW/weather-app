function getWeather() {
    const city = document.getElementById('cityInput').value.trim();
    const resultDiv = document.getElementById('result');

    if (!city) {
        resultDiv.innerHTML = '❗ Please enter a city name.';
        return;
    }

    resultDiv.innerHTML = 'Loading...';

    fetch(`http://localhost:8081/weather?city=${city}`)
        .then(response => {
            if (!response.ok) throw new Error("City not found");
            return response.json();
        })
        .then(data => {
            const temp = (data.main.temp - 273.15).toFixed(1);
            const weather = data.weather[0].description;
            const humidity = data.main.humidity;

            resultDiv.innerHTML = `
                <strong>City:</strong> ${city} <br>
                <strong>Temperature:</strong> ${temp}°C <br>
                <strong>Weather:</strong> ${weather} <br>
                <strong>Humidity:</strong> ${humidity}% 
            `;
        })
        .catch(err => {
            resultDiv.innerHTML = `❌ ${err.message}`;
        });
}
