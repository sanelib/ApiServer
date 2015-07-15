package backend.domain.service.impl;

import backend.domain.Person;
import backend.domain.service.Validator;
import org.springframework.stereotype.Component;

@Component
public class PersonValidator implements Validator<Person> {

    @Override
    public boolean isValid(Person obj) {
        return false;
    }

}
