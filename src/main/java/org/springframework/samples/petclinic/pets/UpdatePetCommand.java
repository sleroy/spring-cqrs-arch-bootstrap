package org.springframework.samples.petclinic.pets;

import org.springframework.samples.petclinic.owner.domain.Owner;
import org.springframework.samples.petclinic.pets.domain.Pet;

import javax.validation.Valid;

public class UpdatePetCommand {
    @Valid
    private final Pet pet;
    @Valid
    private final Owner owner;

    /**
     * Instantiates a new Update pet command.
     *
     * @param pet   the pet
     * @param owner the owner
     */
    public UpdatePetCommand(@Valid Pet pet, Owner owner) {

        this.pet = pet;
        this.owner = owner;
    }


    public Pet getPet() {
        return pet;
    }

    public Owner getOwner() {
        return owner;
    }


    @Override
    public String toString() {
        return "UpdatePetCommand{" +
                "pet=" + pet +
                ", owner=" + owner +
                '}';
    }
}
