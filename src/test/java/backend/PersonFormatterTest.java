package backend;

import backend.dto.Person;
import org.junit.Test;

/*
* Date:16th July 2015
* Test case for personFormatter.
*/

public class PersonFormatterTest extends ContextProviderTest {

    Person person = new Person();

    /**
     * Setting values of FirstName,MiddleName and LastName for testcase.
     * @throws Exception
     */
    @Test
    public void personShouldHaveValidName() throws Exception{

        person.setFirstName("Amrita");
        person.setMiddleName("S");
        person.setLastName("Gianchandani");
    }

    /**
     * Setting value of Sex for testcase.
     * @throws Exception
     */
    @Test
    public void personShouldHaveValidSex() throws Exception{

        person.setSex("F");
    }

    /**
     * Setting value of DateOfBirth for testcase.
     * @throws Exception
     */
    @Test
    public void personShouldHaveValidDateOfBirth() throws Exception {

        person.setDateOfBirth("02/01/1991");
    }
}