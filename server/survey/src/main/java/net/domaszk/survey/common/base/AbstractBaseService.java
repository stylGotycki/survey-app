package net.domaszk.survey.common.base;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public class AbstractBaseService<T, ID> implements BaseService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }
}
