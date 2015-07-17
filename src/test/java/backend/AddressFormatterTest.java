package backend;

import backend.dto.Address;
import org.junit.Test;

public class AddressFormatterTest {
    Address address = new Address();

    @Test
    public void addressShouldHaveValidLineInfo() throws Exception{
        address.setLine1("Line1");
        address.setLine2("Line2");
    }

    @Test
    public void addressShouldContainValidLocation() throws Exception{
        address.setArea("Gota");
        address.setCity("Ahmedabad");
        address.setState("Gujarat");
        address.setCountry("India");
    }

    @Test
    public void addressShouldContainValidZipCode() throws Exception {
        address.setZipCode("380001");
    }
}
