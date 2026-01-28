package net.domaszk.survey.user.domain.event;

import net.domaszk.survey.user.persistence.id.UserId;


public record UserDeletedEvent(UserId userId) {

}
