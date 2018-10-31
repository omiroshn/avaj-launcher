package avaj.weather;

import java.util.Random;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String[] weather;

    public WeatherProvider() {
        if (weatherProvider == null) {
            this.weatherProvider = new WeatherProvider();
            this.weather = new String[4];
            this.weather[0] = "RAIN";
            this.weather[1] = "FOG";
            this.weather[2] = "SUN";
            this.weather[3] = "SNOW";
        }
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int randomValue = coordinates.getHeight() + coordinates.getLatitude()
                + coordinates.getLongitude() * rand.nextInt(4);
        return this.weather[randomValue % 4];
    }
}
