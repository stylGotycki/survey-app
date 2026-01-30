package net.domaszk.survey.survey.domain.event.listener;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import net.domaszk.survey.user.domain.event.UserDeletedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class UserDeletedListener {

    private final SurveyService service;


    //@ApplicationModuleListener
    @Async
    @TransactionalEventListener
    public void onUserDeleted(UserDeletedEvent event) {
        System.out.println("DELETED SURVEYS WHICH REFERENCED USER 2 - start");
        service.deleteByCreator(event.userId());
        System.out.println("DELETED SURVEYS WHICH REFERENCED USER 2 - finish");
    }

}

