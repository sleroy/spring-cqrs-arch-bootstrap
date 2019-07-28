package org.springframework.samples.petclinic.pets;

import com.byoskill.spring.cqrs.commands.CommandServiceSpec;
import com.byoskill.spring.cqrs.commands.EventThrower;
import org.springframework.samples.petclinic.owner.domain.Owner;
import org.springframework.samples.petclinic.pets.commands.CreatePetCommand;
import org.springframework.samples.petclinic.pets.domain.Pet;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CreatePetCommandHandler implements CommandServiceSpec<CreatePetCommand, Pet>, EventThrower<Pet> {

    private PetRepository pets;

    /**
     * Instantiates a new Create pet command handler.
     *
     * @param pets the pets
     */
    public CreatePetCommandHandler(PetRepository pets) {
        this.pets = pets;
    }


    @Override
    public Pet handle(CreatePetCommand command) throws RuntimeException {
        Pet pet = command.getPet();
        Owner owner = command.getOwner();

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            throw new DuplicatedPetException(pet);
        }
        owner.addPet(pet);
        this.pets.save(pet);
        return pet;
    }

    @Override
    public Optional<Object> eventOnFailure(Throwable failure) {
        return Optional.empty();
    }

    /**
     * Triggering event in case of success.
     * @param pet the pet that has been created.
     * @return the created event
     */
    @Override
    public Optional<Object> eventOnSuccess(Pet pet) {
        return Optional.of(new PetCreatedEvent(pet));
    }
}
