package net.domaszk.survey.common.base;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class BaseRestMapper {

    protected <T> void updateIfNotNull(Supplier<T> getter, Consumer<T> setter) {
        T value = getter.get();
        if (value != null) {
            setter.accept(value);
        }
    }

}
