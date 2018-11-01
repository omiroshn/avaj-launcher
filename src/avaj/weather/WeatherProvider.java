package avaj.weather;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int randomValue = coordinates.getHeight() + coordinates.getLatitude()
                + coordinates.getLongitude() * rand.nextInt(4);
        return weather[randomValue % 4];
    }
}
