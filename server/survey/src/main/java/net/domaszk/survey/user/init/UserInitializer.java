package net.domaszk.survey.user.init;


import lombok.RequiredArgsConstructor;
import net.domaszk.survey.user.domain.service.api.UserService;
import net.domaszk.survey.user.persistence.entity.UserEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInitializer implements InitializingBean {

    private final UserService userService;

    @Override
    public void afterPropertiesSet() {
        UserEntity entity = UserEntity.builder()
                .email("t@t.t")
                .username("user")
                .passwordHash("trelemorele")
                .build();

        userService.save(entity);
        userService.delete(entity);
    }

}
