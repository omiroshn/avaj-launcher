package avaj.simulator.vehicles;

import avaj.exceptions.ParseFileException;
import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions() throws ParseFileException;
    public void registerTower(WeatherTower WeatherTower, Logger file);
}
