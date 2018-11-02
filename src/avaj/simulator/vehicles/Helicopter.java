package avaj.simulator.vehicles;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    Helicopter(String type, String name, Coordinates coordinates) {
        super(type, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int[][] coords = {{0,10,2},{0,5,0},{0,1,0},{0,0,-12}};
        String[] msg = {"Let's enjoy the good weather and take some pics.\n", "It's raining. Better watch out for lightings.\n", "It's foggy.\n", "OMG! Winter is coming!\n"};
        int update = super.update(coords, weather, msg);
        if (update == 0) {
            this.weatherTower.unregister(this);
            this.logger.writeToFile("Tower says: " + this.getType() + "#" + this.getName() + "(" + this.getId() + ") unregistered from weather tower.\n");
        }
    }

    @Override
    public void registerTower(WeatherTower WeatherTower, Logger file) {
        this.logger = file;
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
        file.writeToFile("Tower says: " + this.getType() + "#" + this.getName() + "(" + this.getId() + ") registered to weather tower.\n");
    }
}
