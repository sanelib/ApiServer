package backend.dto.formatter.impl;

import backend.dto.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressFormatter extends Formatter<Address> {

    @Override
    public boolean apply(Address address) {
        return isNotEmpty(address.getArea()) &&
                isNotEmpty(address.getCity()) &&
                isNotEmpty(address.getCountry()) &&
                isNotEmpty(address.getLine1()) &&
                isNotEmpty(address.getLine2()) &&
                isNotEmpty(address.getState()) &&
                isValidNumber(address.getZipCode());
    }
}