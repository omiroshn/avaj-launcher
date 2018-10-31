package avaj.simulator;

import avaj.simulator.vehicles.Flyable;

import java.util.ArrayList;

public class Tower {

    private ArrayList<Flyable> arrayFlyable = new ArrayList<>();

    public void register(Flyable flyable) {
        arrayFlyable.add(flyable);
    }

    public void unregister(Flyable flyable) {
        arrayFlyable.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable observer : arrayFlyable) {
            observer.updateConditions();
        }
    }
}
