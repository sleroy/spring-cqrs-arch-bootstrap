package org.springframework.samples.petclinic.owner;

import com.byoskill.spring.cqrs.annotations.CommandHandler;
import com.byoskill.spring.cqrs.annotations.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.commands.CreateOwnerCommand;
import org.springframework.samples.petclinic.owner.commands.UpdateOwnerCommand;
import org.springframework.samples.petclinic.owner.domain.Owner;

@CommandService
public class OwnerCommandHandler {

    private OwnerRepository owners;

    @Autowired
    public OwnerCommandHandler(OwnerRepository owners) {
        this.owners = owners;
    }

    @CommandHandler
    public Owner saveOwner(CreateOwnerCommand createOwnerCommand) {
        Owner owner = createOwnerCommand.getOwner();
        owners.save(owner);
        return owner;
    }

    @CommandHandler
    public Owner updateOwner(UpdateOwnerCommand updateOwnerCommand) {
        Owner owner = updateOwnerCommand.getOwner();
        int ownerId = updateOwnerCommand.getOwnerId();

        owner.setId(ownerId);
        this.owners.save(owner);
        return owner;
    }
}
