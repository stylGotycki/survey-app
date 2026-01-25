package net.domaszk.survey.common.base;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
public abstract class Id<E> {

    private final UUID id;

}
