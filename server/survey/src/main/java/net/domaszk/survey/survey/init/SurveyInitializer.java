package net.domaszk.survey.survey.init;

import lombok.RequiredArgsConstructor;
import net.domaszk.survey.survey.domain.service.api.SurveyService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyInitializer implements InitializingBean {

    private final SurveyService service;

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("i don't need this now?");

    }
}
