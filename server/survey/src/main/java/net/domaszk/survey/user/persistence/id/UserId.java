package net.domaszk.survey.user.persistence.id;

import lombok.*;
import net.domaszk.survey.common.base.Id;
import net.domaszk.survey.user.persistence.entity.UserEntity;

import java.util.UUID;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserId extends Id<UserEntity> {

    public UserId(UUID id) {
        super(id);
    }

    public static UserId of(UUID id) {
        return new UserId(id);
    }


    public static UserId of(UserEntity entity) {
        return new UserId(entity.getId());
    }
}
