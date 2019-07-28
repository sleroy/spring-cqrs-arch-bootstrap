package org.springframework.samples.petclinic.pets.commands;

import org.springframework.samples.petclinic.owner.domain.Owner;
import org.springframework.samples.petclinic.pets.domain.Pet;

import javax.validation.Valid;

public class CreatePetCommand {
    @Valid
    private final Owner owner;


    @Valid
    private final Pet pet;

    /**
     * Instantiates a new Create pet command.
     *
     * @param owner the owner
     * @param pet   the pet
     */
    public CreatePetCommand(Owner owner, @Valid Pet pet) {
        this.owner = owner;
        this.pet = pet;
    }


    public Pet getPet() {
        return pet;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "CreatePetCommand{" +
                "owner=" + owner +
                ", pet=" + pet +
                '}';
    }

}
