package avaj.simulator.vehicles;

import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
