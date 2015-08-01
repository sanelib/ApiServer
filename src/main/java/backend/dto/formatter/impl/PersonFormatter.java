package backend.dto.formatter.impl;

import backend.dto.Person;
import org.springframework.stereotype.Component;

import java.util.Objects;

/*
* Date:16th July 2015
* Defining formats for fields of person class.
*/

@Component
public class PersonFormatter extends Formatter<Person> {

    /**
     *
     * @param  person
     * @return boolean result of data in person fields.
     */
    @Override
    public boolean apply(Person person) {

        boolean isValidName = isValidName(person.getFirstName(), person.getMiddleName(), person.getLastName());
        boolean isValidSex = isValidSex(person.getSex());
        boolean dateOfBirthIsValid = isValidDateFormat(person.getDateOfBirth());

        return (isValidName) &&
               (isValidSex) &&
               (dateOfBirthIsValid);
    }

    /**
     *
     * @param  firstName
     * @param  middleName
     * @param  lastName
     * @return boolean result of firstName,middleName and lastName.
     */
    public boolean isValidName(String firstName, String middleName, String lastName){

        return (firstName != null || firstName.length() == 0) &&
               (middleName != null || middleName.length() == 0) &&
               (lastName != null || lastName.length() == 0);
    }

    /**
     *
     * @param  sex
     * @return boolean result of sex.
     */
    public boolean isValidSex(String sex){

        return (Objects.equals(sex, "M")) ||
               (Objects.equals(sex, "F"));
    }

    /**
     *
     * @param  date
     * @return boolean result of date.
     */
    public boolean isValidDateFormat(String date) {

        if (date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
            return true;
        else
            return false;
    }
}