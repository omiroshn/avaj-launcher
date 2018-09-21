package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.weather.Coordinates;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private long idCounter;

    public Aircraft() {}

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {

        return this.id;
    }

}
