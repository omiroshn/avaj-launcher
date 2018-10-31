package avaj.simulator.vehicles;

import avaj.weather.Coordinates;

public class Aircraft {

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
