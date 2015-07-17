package backend;

import backend.dto.Person;
import org.junit.Test;

/*
* Date:16th July 2015
* Creating Test case for personFormatter
*/

public class PersonFormatterTest extends ContextProviderTest {

    Person person = new Person();
    @Test
    public void personShouldHaveValidName() throws Exception{
        person.setFirstName("Amrita");
        person.setMiddleName("S");
        person.setLastName("Gianchandani");
    }
    @Test
    public void personShouldHaveValidSex() throws Exception{
        person.setSex("F");
    }
    @Test
    public void personShouldHaveValidDateOfBirth() throws Exception {

        person.setDateOfBirth("02/01/1991");
    }
}