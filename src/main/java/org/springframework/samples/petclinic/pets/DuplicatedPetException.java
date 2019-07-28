package org.springframework.samples.petclinic.pets;

import org.springframework.samples.petclinic.pets.domain.Pet;

public class DuplicatedPetException extends RuntimeException {

    private Pet pet;

    public DuplicatedPetException(Pet pet) {

        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

}
