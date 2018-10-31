package avaj.simulator.vehicles;

import avaj.exceptions.ParseFileException;
import avaj.weather.Coordinates;

import java.util.Objects;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws ParseFileException {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable newFlyable;

        if (Objects.equals(type, "Baloon")) {
            newFlyable = new Baloon(type, name, coordinates);
        } else if (Objects.equals(type, "Helicopter")) {
            newFlyable = new Helicopter(type, name, coordinates);
        } else if (Objects.equals(type, "JetPlane")) {
            newFlyable = new JetPlane(type, name, coordinates);
        } else {
            throw new ParseFileException("Unknown type of a Flyable : " + type);
        }
        return newFlyable;
    }

}
