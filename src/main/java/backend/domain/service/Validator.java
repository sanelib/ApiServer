package backend.domain.service;

import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {
    boolean isValid(T obj);
}
