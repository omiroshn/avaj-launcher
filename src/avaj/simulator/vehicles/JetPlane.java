package avaj.simulator.vehicles;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    JetPlane(String type, String name, Coordinates coordinates) {
        super(type, name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        int[][] coords = {{10,0,2},{5,0,0},{1,0,0},{0,0,-7}};
        String[] msg = {"Let's enjoy the good weather and take some pics.", "It's raining. Better watch out for lightings.", "It's foggy.", "OMG! Winter is coming!"};
        super.update(coords, weather, msg);
    }

    @Override
    public void registerTower(WeatherTower WeatherTower, Logger file) {
        this.logger = file;
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
        file.writeToFile("Tower says: " + this.getType() + "#" + this.getName() + "(" + this.getId() + ") registered to weather tower.\n");
    }
}
