package avaj.weather;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String[] weather;

    public WeatherProvider(WeatherProvider weatherProvider, String[] weather) {
        this.weatherProvider = weatherProvider;
        this.weather = weather;
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        return "new weather";
    }
}
