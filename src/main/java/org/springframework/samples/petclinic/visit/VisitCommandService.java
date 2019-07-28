package org.springframework.samples.petclinic.visit;

import com.byoskill.spring.cqrs.annotations.CommandHandler;
import com.byoskill.spring.cqrs.annotations.CommandService;
import com.byoskill.spring.cqrs.events.EventBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.visit.commands.SaveNewVisitCommand;
import org.springframework.samples.petclinic.visit.domain.Visit;
import org.springframework.samples.petclinic.visit.events.VisitCreatedEvent;

@CommandService
public class VisitCommandService {

    private EventBusService eventBus;

    /**
     * Instantiates a new Visit command handler.
     *
     * @param eventBus the event bus
     * @param visits   the visits
     */
    @Autowired
    public VisitCommandService(EventBusService eventBus, VisitRepository visits) {
        this.eventBus = eventBus;
        this.visits = visits;
    }

    private VisitRepository visits;

    @CommandHandler
    public Visit createNewVisit(SaveNewVisitCommand saveNewVisitCommand) {
        Visit visit = saveNewVisitCommand.getVisit();
        visits.save(visit);

        eventBus.publishEvent(new VisitCreatedEvent(visit));
        return visit;
    }
}
