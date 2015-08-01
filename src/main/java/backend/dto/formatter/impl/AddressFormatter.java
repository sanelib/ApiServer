package backend.dto.formatter.impl;

import backend.dto.Address;
import org.springframework.stereotype.Component;

/*
* Date:16th July 2015
* Defining formats for fields of address class
*/

@Component(value = "AddressFormatter")
class AddressFormatter extends Formatter<Address> {

    /**
     *
     * @param  address
     * @return boolean result of data in address fields.
     */
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