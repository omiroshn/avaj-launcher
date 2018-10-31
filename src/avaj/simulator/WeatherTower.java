package avaj.simulator;

import avaj.simulator.vehicles.Flyable;
import avaj.weather.Coordinates;
import avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        WeatherProvider provider = new WeatherProvider();
        return provider.getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        conditionsChanged();
    }

    @Override
    public void register(Flyable flyable) {
        super.register(flyable);
    }

    @Override
    public void unregister(Flyable flyable) {
        super.unregister(flyable);
    }

    @Override
    protected void conditionsChanged() {
        super.conditionsChanged();
    }
}
