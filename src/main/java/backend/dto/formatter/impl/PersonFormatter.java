package backend.dto.formatter.impl;

import backend.dto.Person;
import backend.dto.formatter.Formatter;
import org.springframework.stereotype.Component;

import java.util.Objects;

/*
* Date:16th July 2015
* Defining formats for fields of person class
*/

@Component
public class PersonFormatter implements Formatter<Person> {

    @Override
    public boolean apply(Person obj) {

        boolean isValidName = isValidName(obj.getFirstName(), obj.getMiddleName(), obj.getLastName());
        boolean isValidSex = isValidSex(obj.getSex());
        boolean dateOfBirthIsValid = isValidDateFormat(obj.getDateOfBirth());
        return dateOfBirthIsValid && isValidName && isValidSex;
    }

    public boolean isValidDateFormat(String date) {
        if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
            return true;
        else
            return false;
    }

    public boolean isValidSex(String sex){return Objects.equals(sex, "M") || Objects.equals(sex, "F");
    }

    public boolean isValidName(String firstName, String middleName, String lastName){
        return firstName != null || firstName.length() == 0 && middleName != null || middleName.length() == 0 && lastName != null || lastName.length() == 0;
    }
}
