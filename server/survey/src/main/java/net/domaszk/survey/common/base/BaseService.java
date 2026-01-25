package net.domaszk.survey.common.base;

public interface BaseService<T, ID> {

    Iterable<T> findAll();

    T findById(ID id);

    boolean existsById(ID id);

    T save(T entity);

    void delete(T entity);

}
