package backend.formatter;

import backend.dto.Address;
import backend.dto.formatter.impl.Formatter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.*;

/**
 * Created by Z21 on 01-Aug-15.
 */
public class AddressFormatterTest extends BaseFormatterTest {

    @Autowired
    @Qualifier(value = "AddressFormatter")
    private Formatter addressFormatter;

    @Override
    public boolean checkFormat(Object obj) {
        return addressFormatter.apply(obj);
    }

    @Test
    public void testAllValidAddressFields(){
        Address address = new Address();
        address.setArea("Gota");
        address.setCity("Ahmedabad");
        address.setCountry("India");
        address.setLine1("line1");
        address.setLine2("line2");
        address.setState("gujarat");
        address.setZipCode("356");

        assertTrue(checkFormat(address));
    }

    @Test
    public void testEmptyCityField(){
        Address address = new Address();
        address.setArea("Gota");
        address.setLine1("None");
        address.setLine2("NA");
        address.setCity("");
        address.setCountry("India");
        address.setState("Gujarat");
        address.setZipCode("380005");

        assertFalse(checkFormat(address));
    }

    @Test
    public void testInvalidZipCode(){
        Address address = new Address();
        address.setArea("Gota");
        address.setLine1("None");
        address.setLine2("NA");
        address.setCity("Ahmedabad");
        address.setCountry("India");
        address.setState("Gujarat");
        address.setZipCode("Three");

        assertFalse(checkFormat(address));

    }

    @Test
    public void testNullAddressField(){
        Address address = new Address();
        address.setArea("Gota");
        address.setCity("Ahmedabad");
        address.setCountry("India");
        address.setState("Gujarat");
        address.setZipCode("380005");

        assertFalse(checkFormat(address));
    }
}
