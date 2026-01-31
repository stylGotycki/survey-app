package net.domaszk.survey.config;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DebugListener {

    @EventListener
    public void onApplicationEvent(Object e) {
        System.out.println("event: " + e.getClass().getName());
    }

}
