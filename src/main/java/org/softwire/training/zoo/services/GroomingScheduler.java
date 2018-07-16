package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.CanBeGroomed;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public class GroomingScheduler {
    private static GroomingScheduler instance;

    private GroomingScheduler() {
    }

    public static GroomingScheduler getInstance() {
        if (instance == null) {
            instance = new GroomingScheduler();
        }
        return instance;
    }

    public void assignGroomingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanBeGroomed) {
                keeper.groom((CanBeGroomed) animal);
            }
        }));
    }
}
