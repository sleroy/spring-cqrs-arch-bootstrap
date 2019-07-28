package org.springframework.samples.petclinic.owner.commands;

import org.springframework.samples.petclinic.owner.domain.Owner;

import javax.validation.Valid;

/**
 * This command is sued to create a new owner.
 */
public class CreateOwnerCommand {

    @Valid
    private Owner owner;

    /**
     * Instantiates a new Create owner command.
     *
     * @param owner the owner
     */
    public CreateOwnerCommand(Owner owner) {

        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

}
