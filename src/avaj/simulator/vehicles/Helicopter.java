package avaj.simulator.vehicles;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String type, String name, Coordinates coordinates) {
        super(type, name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower WeatherTower, Logger file) {
        WeatherTower.register(this);
        file.writeToFile("Tower says: " + this.getType() + "#" + this.getName() + "(" + this.getId() + ") registered to weather tower.\n");
    }
}
