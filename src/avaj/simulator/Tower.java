package avaj.simulator;

import avaj.simulator.vehicles.Flyable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Tower {

    private List<Flyable> arrayFlyable = new CopyOnWriteArrayList<>();

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
