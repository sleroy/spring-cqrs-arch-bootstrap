package org.springframework.samples.petclinic.pets;

import com.byoskill.spring.cqrs.annotations.CommandService;
import com.byoskill.spring.cqrs.commands.CommandServiceSpec;
import org.springframework.samples.petclinic.owner.domain.Owner;
import org.springframework.samples.petclinic.pets.commands.InitializationPetCommand;
import org.springframework.samples.petclinic.pets.domain.Pet;

@CommandService
public class InitializationPetCommandHandler implements CommandServiceSpec<InitializationPetCommand, Pet> {
    @Override
    public Pet handle(InitializationPetCommand command) throws RuntimeException {
        Owner owner = command.getOwner();

        Pet pet = new Pet();
        owner.addPet(pet);
        return pet;
    }
}
