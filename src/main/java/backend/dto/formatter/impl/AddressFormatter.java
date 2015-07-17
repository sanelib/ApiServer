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

    @Override
    public boolean apply(Address obj) {
        boolean isValidLine = isValidLineValue(obj.getLine1(), obj.getLine2());
        boolean isValidLocationValue = isValidLocation(obj.getArea() , obj.getCity() , obj.getState() , obj.getCountry());
        boolean zipCodeIsValid = isValidZipCode(obj.getZipCode());

        return isValidLine && isValidLocationValue && zipCodeIsValid;
    }

    public boolean isValidZipCode(String zipCode){
        if(zipCode.matches("[0-9]{6}"))
            return true;
        else
            return false;
    }

    public boolean isValidLineValue(String line1, String line2){
        return line1 != null || line1.length() == 0 && line2 != null || line2.length() == 0;
    }

    public boolean isValidLocation(String area,String city, String state,String country){
        return city != null || city.length() == 0 && state != null || state.length() == 0 && country !=null || country.length() == 0;
    }

}

