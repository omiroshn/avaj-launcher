package avaj.simulator.vehicles;

import avaj.exceptions.ParseFileException;
import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    Helicopter(String type, String name, Coordinates coordinates) {
        super(type, name, coordinates);
    }

    @Override
    public void updateConditions() throws ParseFileException {
        String weather = weatherTower.getWeather(this.coordinates);
        int[][] coords = {{0,10,2},{0,5,0},{0,1,0},{0,0,-12}};
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
