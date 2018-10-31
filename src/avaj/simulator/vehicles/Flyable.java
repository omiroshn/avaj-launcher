package avaj.simulator.vehicles;

import avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
