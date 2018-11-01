package avaj.simulator.vehicles;

import avaj.simulator.Logger;
import avaj.simulator.WeatherTower;
import avaj.weather.Coordinates;

public class Aircraft {

    protected WeatherTower weatherTower;
    protected Logger logger;

    protected int id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;

    private static int counterId = 0;

    protected Aircraft(String type, String name, Coordinates coordinates) {
        this.id = nextId();
        this.type = type;
        this.name = name;
        this.coordinates = coordinates;
    }

    public void update(int[][] coords, String weather, String[] msg) {
        int weatherState = 0;
        switch (weather) {
            case "SUN":
                weatherState = 0;
                break;
            case "RAIN":
                weatherState = 1;
                break;
            case "FOG":
                weatherState = 2;
                break;
            case "SNOW":
                weatherState = 3;
                break;
        }
        this.coordinates = new Coordinates(
                this.coordinates.getLatitude() + coords[weatherState][0],
                this.coordinates.getLatitude() + coords[weatherState][1],
                this.coordinates.getHeight() + coords[weatherState][2]);
        logger.writeToFile(this.type + "#" + this.name + "(" + this.id + "): " + msg[weatherState]);
    }

    private int nextId() {
        return ++counterId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
