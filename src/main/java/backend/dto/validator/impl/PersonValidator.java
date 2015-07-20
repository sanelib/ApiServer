package backend.dto.validator.impl;

import backend.dto.Person;
import backend.dto.validator.Validator;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Date:17th July 2015
 * Defining validations for person fields.
 */

@Component
public class PersonValidator implements Validator<Person> {

    /**
     *
     * @param  person
     * @return boolean result of entries done in person.
     */
    @Override
    public boolean isValid(Person person) {
        boolean isValidString = isValidStringEntry(person.getFirstName(), person.getMiddleName(), person.getLastName(), person.getSex());
        boolean isValidDate = isValidDateEntry(person.getDateOfBirth());

        return (isValidString) &&
               (isValidDate);
    }

    /**
     *
     * @param  firstName
     * @param  middleName
     * @param  lastName
     * @param  sex
     * @return boolean result of firstName,middleName,lastName and sex.
     */
    public boolean isValidStringEntry(String firstName, String middleName, String lastName, String sex) {

        return (firstName.matches("[a-zA-Z]+") || firstName.length() > 30) &&
               (middleName.matches("[a-zA-Z]+") || middleName.length() > 30) &&
               (lastName.matches("[a-zA-Z]+") || lastName.length() > 30) &&
               (Objects.equals(sex, "M") || Objects.equals(sex, "F"));
    }

    /**
     *
     * @param  dateInString
     * @return boolean value of date.
     */
    public boolean isValidDateEntry(String dateInString){

        // Invalid date is not acceptable. Date must be entered in "dd/MM/yyyy" format.
        // Valid date: 29/02/2016, 16/07/2015
        // Invalid date: 29/02/2015, 32/01/2015, 10/001/2016
        SimpleDateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        try {
            if (dateInString.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
                Date date = formatter.parse(dateInString);

                return true;
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}

