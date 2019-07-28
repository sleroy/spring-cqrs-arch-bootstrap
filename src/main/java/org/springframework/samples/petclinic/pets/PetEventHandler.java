package org.springframework.samples.petclinic.pets;

import com.byoskill.spring.cqrs.annotations.EventHandler;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EventHandler
public class PetEventHandler {

    private static final Logger log = LoggerFactory.getLogger(PetEventHandler.class);

    @Subscribe
    public void eventPetCreated(PetCreatedEvent petCreatedEvent) {
        log.info("Pet event has been created {}", petCreatedEvent);
    }


}
