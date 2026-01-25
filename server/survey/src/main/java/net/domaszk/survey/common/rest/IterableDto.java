package net.domaszk.survey.common.rest;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Builder
public class IterableDto<T> {

    @Singular
    private List<T> items;

}
