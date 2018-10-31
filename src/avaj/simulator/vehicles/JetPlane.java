package avaj.simulator.vehicles;

import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {

    }
}
