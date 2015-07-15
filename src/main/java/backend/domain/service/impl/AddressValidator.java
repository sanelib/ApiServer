package backend.domain.service.impl;

import backend.domain.Address;
import backend.domain.Person;
import backend.domain.service.Validator;
import org.springframework.stereotype.Component;

@Component
public class AddressValidator implements Validator<Address> {

    @Override
    public boolean isValid(Address obj) {
        return true;
    }

}
