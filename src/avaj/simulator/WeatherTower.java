package avaj.simulator;

import avaj.exceptions.ParseFileException;
import avaj.simulator.vehicles.Flyable;
import avaj.weather.Coordinates;
import avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() throws ParseFileException {
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
    protected void conditionsChanged() throws ParseFileException {
        super.conditionsChanged();
    }
}
