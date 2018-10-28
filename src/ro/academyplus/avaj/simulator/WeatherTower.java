package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.simulator.vehicles.Flyable;
import ro.academyplus.avaj.weather.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return "Weather";
    }

    public void changeWeather() {

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
