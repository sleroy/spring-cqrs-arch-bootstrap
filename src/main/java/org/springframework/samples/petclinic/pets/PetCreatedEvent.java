package org.springframework.samples.petclinic.pets;

import org.springframework.samples.petclinic.pets.domain.Pet;

public class PetCreatedEvent {

    private final Pet pet;

    /**
     * Instantiates a new Pet created event.
     *
     * @param pet the pet
     */
    public PetCreatedEvent(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }


    @Override
    public String toString() {
        return "PetCreatedEvent{" +
                "pet=" + pet +
                '}';
    }

}
