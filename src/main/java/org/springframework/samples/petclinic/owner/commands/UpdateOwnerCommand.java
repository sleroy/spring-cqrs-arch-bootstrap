package org.springframework.samples.petclinic.owner.commands;

import org.springframework.samples.petclinic.owner.domain.Owner;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

public class UpdateOwnerCommand {

    @Valid
    private Owner owner;
    @PositiveOrZero
    private int ownerId;

    /**
     * Instantiates a new Update owner command.
     *
     * @param owner   the owner
     * @param ownerId the owner id
     */
    public UpdateOwnerCommand(@Valid Owner owner, int ownerId) {
        this.owner = owner;
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }


    public Owner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "UpdateOwnerCommand{" +
                "owner=" + owner +
                '}';
    }

}
