package backend.dto.validator;

import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {
    boolean isValid(T obj);
}
