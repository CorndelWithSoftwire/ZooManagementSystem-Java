package org.softwire.training.zoo.models;

import java.time.LocalDate;

public class Lion extends AbstractAnimal implements LargeAnimal {
    public Lion(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }
}
