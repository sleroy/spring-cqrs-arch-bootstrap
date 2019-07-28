package org.springframework.samples.petclinic.pets.commands;

import org.springframework.samples.petclinic.owner.domain.Owner;

import javax.validation.Valid;

/**
 * The type Create pet command is associated to the creation of the command.
 */
public class InitializationPetCommand {

    @Valid
    private Owner owner;

    public InitializationPetCommand(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }
    @Override
    public String toString() {
        return "InitializationPetCommand{" +
                "owner=" + owner +
                '}';
    }

}
