package backend;

import backend.dto.Address;
import org.junit.Test;

/**
 * Date: 16/07/2015
 * Test case for addressFormatter.
 */

public class AddressFormatterTest {
    Address address = new Address();

    /**
     * Setting values of Line1 and Line2 for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldHaveValidLineInfo() throws Exception{

        address.setLine1("Line1");
        address.setLine2("Line2");
    }

    /**
     * Setting values of Area,City,State and country for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldContainValidLocation() throws Exception{

        address.setArea("Gota");
        address.setCity("Ahmedabad");
        address.setState("Gujarat");
        address.setCountry("India");
    }

    /**
     * Setting value of zipCode for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldContainValidZipCode() throws Exception {

        address.setZipCode("380001");
    }
}
