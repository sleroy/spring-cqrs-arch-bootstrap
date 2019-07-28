package org.springframework.samples.petclinic.system;

import com.byoskill.spring.cqrs.throttling.ThrottlingInterface;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

/**
 * The type Throttling service illustrates how to implement a basic throttling mechanism.
 */
@Service
public class ThrottlingService implements ThrottlingInterface {
    public static final String VISIT_CREATION = "VISIT_CREATION";

    public RateLimiter rateLimiter = RateLimiter.create(2);

    @Override
    public void acquirePermit(String name) {
        switch(name) {
            case VISIT_CREATION:
                rateLimiter.acquire();
                break;
        }
    }
}
