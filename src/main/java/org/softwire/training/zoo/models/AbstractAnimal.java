package org.softwire.training.zoo.models;

import org.softwire.training.zoo.Config;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AbstractAnimal implements Animal {
    private LocalDate dateOfBirth;
    private LocalDateTime lastFed;

    protected AbstractAnimal(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Duration age() {
        return Duration.between(LocalDate.now(), dateOfBirth);
    }

    @Override
    public void feed() {
        lastFed = LocalDateTime.now();
    }

    @Override
    public boolean isHungry() {
        // Obviously an animal wouldn't get hungry in a matter of seconds.
        // But it means we can see activity in real time when we run the code...
        return Duration.between(LocalDateTime.now(), lastFed).compareTo(Config.getFeedingFrequency()) > 0;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}, last fed {1}", getClass().getSimpleName(), lastFed);
    }
}
