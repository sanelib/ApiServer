package backend.dto.formatter.impl;

import backend.dto.Address;
import backend.dto.formatter.Formatter;
import org.springframework.stereotype.Component;

/*
* Date:16th July 2015
* Defining formats for fields of address class
*/

@Component
class AddressFormatter implements Formatter<Address> {

    /**
     *
     * @param  address
     * @return boolean result of data in address fields.
     */
    @Override
    public boolean apply(Address address) {
        boolean isValidLine = isValidLineValue(address.getLine1(), address.getLine2());
        boolean isValidLocationValue = isValidLocation(address.getArea(), address.getCity(), address.getState(), address.getCountry());
        boolean zipCodeIsValid = isValidZipCode(address.getZipCode());

        return (isValidLine) &&
               (isValidLocationValue) &&
               (zipCodeIsValid);
    }

    /**
     *
     * @param  line1
     * @param  line2
     * @return boolean result of line1 and line2.
     */
    public boolean isValidLineValue(String line1, String line2){

        return (line1 != null || line1.length() == 0) &&
               (line2 != null || line2.length() == 0);
    }

    /**
     *
     * @param  area
     * @param  city
     * @param  state
     * @param  country
     * @return boolean value of area,city,state and country.
     */
    public boolean isValidLocation(String area, String city, String state, String country){

        return (area != null || area.length() == 0) &&
               (city != null || city.length() == 0) &&
               (state != null || state.length() == 0) &&
               (country != null || country.length() == 0);
    }

    /**
     *
     * @param zipCode
     * @return boolean value of zipCode.
     */
    public boolean isValidZipCode(String zipCode){

        if(zipCode.matches("[0-9]"))
            return true;
        else
            return false;
    }
}

