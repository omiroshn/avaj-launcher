package avaj.simulator.vehicles;

import avaj.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable newFlyable;

        if (type == "Baloon") {
            newFlyable = new Baloon(name, coordinates);
        } else if (type == "Helicopter") {
            newFlyable = new Helicopter(name, coordinates);
        } else if (type == "JetPlane") {
            newFlyable = new JetPlane(name, coordinates);
        }
        else {
            newFlyable = new JetPlane(name, coordinates);
        }
//        else {
//            throw ;
//        }
        return newFlyable;
    }
}
