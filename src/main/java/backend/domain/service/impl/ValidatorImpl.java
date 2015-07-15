package backend.domain.service.impl;

import backend.domain.service.Validator;

public class ValidatorImpl<Person> implements Validator<Person> {

    @Override
    public boolean isValid(Person obj) {
        return false;
    }

}
