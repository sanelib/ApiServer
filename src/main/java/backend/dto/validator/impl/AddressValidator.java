package backend.dto.validator.impl;

import backend.dto.Address;
import backend.dto.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Date:17th July 2015
 * Defining validations for address.
 */
@Component
public class AddressValidator implements Validator<Address> {

    /**
     *
     * @param  address
     * @return boolean result of entries done in address.
     */
    @Override
    public boolean isValid(Address address) {
        boolean isValidPlace = isValidPlaceEntry(address.getLine1(), address.getLine2(), address.getArea());
        boolean isValidLocation = isValidLocationEntry(address.getCity() ,address.getState() ,address.getCountry());
        boolean isVaildZipCode = isValidZipCodeEntry(address.getZipCode());

        return (isValidPlace) &&
               (isValidLocation) &&
               (isVaildZipCode);
    }

    /**
     *
     * @param  line1
     * @param  line2
     * @param  area
     * @return boolean result of line1,line2 and area.
     */
    public boolean isValidPlaceEntry(String line1,String line2,String area){

        return (line1.matches("[a-zA-Z0-9-/.]+")) &&
               (line2.matches("[a-zA-Z0-9-/.]+")) &&
               (area.matches("[a-zA-Z0-9-/.]+"));
    }

    /**
     *
     * @param  city
     * @param  state
     * @param  country
     * @return boolean result of city,state and country.
     */
    public boolean isValidLocationEntry(String city, String state,String country){

        return (city.matches("[a-zA-Z]+") || city.length() > 30) &&
               (state.matches("[a-zA-Z]+") || state.length() > 30) &&
               (country.matches("[a-zA-Z]+") || country.length() > 30);
    }

    /**
     *
     * @param  zipCode
     * @return boolean result of zipCode.
     */
    public boolean isValidZipCodeEntry(String zipCode){

        return (zipCode.length() > 10);
    }
}
