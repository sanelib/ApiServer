package backend.dto.formatter;

import org.springframework.stereotype.Component;

@Component
public interface Formatter<T> {
    boolean apply(T obj);
}
