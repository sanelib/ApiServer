package backend;

import backend.dto.Address;
import org.junit.Test;

/**
 * Date:17th July 2015
 * Test case for addressValidator.
 */

public class AddressValidatorTest extends ContextProviderTest {
    Address address = new Address();

    /**
     * Setting values of Line1,Line2 and Area for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldContainValidPlaceInfo() throws Exception{

        address.setLine1("Line1");
        address.setLine2("Line2");
        address.setArea("Gota");
    }

    /**
     * Setting values of City,State and Country for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldContainValidLocation() throws Exception{

        address.setCity("Ahmedabad");
        address.setState("Gujarat");
        address.setCountry("India");
    }

    /**
     * Setting value for zipCode for testcase.
     * @throws Exception
     */
    @Test
    public void addressShouldContainValidZipCode() throws Exception {

        address.setZipCode("380001");
    }
}
