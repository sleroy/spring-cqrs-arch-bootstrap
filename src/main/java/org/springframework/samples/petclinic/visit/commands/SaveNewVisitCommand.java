package org.springframework.samples.petclinic.visit.commands;

import com.byoskill.spring.cqrs.annotations.Throttle;
import org.springframework.samples.petclinic.system.ThrottlingService;
import org.springframework.samples.petclinic.visit.domain.Visit;

import javax.validation.Valid;

@Throttle(ThrottlingService.VISIT_CREATION)
public class SaveNewVisitCommand {


    @Valid
    private Visit visit;

    /**
     * Instantiates a new Save new visit command.
     *
     * @param visit the visit
     */
    public SaveNewVisitCommand(@Valid Visit visit) {

        this.visit = visit;
    }

    public Visit getVisit() {
        return visit;
    }


    @Override
    public String toString() {
        return "SaveNewVisitCommand{" +
                "visit=" + visit +
                '}';
    }
}
