package org.springframework.samples.petclinic.visit.events;

import org.springframework.samples.petclinic.visit.domain.Visit;

/**
 * The event is thrown when a visit has been created.
 */
public class VisitCreatedEvent {

    private final Visit visit;

    /**
     * Instantiates a new Visit created event.
     *
     * @param visit the visit
     */
    public VisitCreatedEvent(Visit visit) {
        this.visit = visit;
    }

    /**
     * Gets visit.
     *
     * @return the visit
     */
    public Visit getVisit() {
        return visit;
    }


    @Override
    public String toString() {
        return "VisitCreatedEvent{" +
                "visit=" + visit +
                '}';
    }
}
