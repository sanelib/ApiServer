package backend.domain.service;

public interface Validator<T> {
    boolean isValid(T obj);
}
