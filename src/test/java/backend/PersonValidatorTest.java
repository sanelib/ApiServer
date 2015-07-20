package backend;

import backend.dto.Person;
import org.junit.Test;

/**
 * Date:17th July 2015
 * Test case for personValidator.
 */

public class PersonValidatorTest {
    Person person = new Person();

    /**
     * Setting values of FirstName,MiddleName LastName and Sex for testcase.
     * @throws Exception
     */
    @Test
    public void personShouldContainValidBasicInfo() throws Exception{

        person.setFirstName("Amrita");
        person.setMiddleName("S");
        person.setLastName("Gianchandani");
        person.setSex("F");
    }

    /**
     * Setting value of DateOfBirth for testcase.
     * @throws Exception
     */
    @Test
    public void personShouldEnterValidDateOfBirth() throws Exception{

        person.setDateOfBirth("08/07/1991");
    }
}
