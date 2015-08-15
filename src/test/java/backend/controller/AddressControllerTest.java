package backend.controller;

import backend.BaseTest;
import backend.controllerapis.AddressController;
import backend.dto.Address;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.*;

/**
 * Created by zaidikkis on 15-Aug-15.
 */
public class AddressControllerTest extends BaseTest {

    @Autowired
    private AddressController addressController;

    Address command = new Address();

    @Before
    public void setUp(){
        command.setLine1("Line1");
        command.setLine2("Line2");
        command.setArea("Ghatlodia");
        command.setState("Gujarat");
        command.setCity("Ahmedabad");
        command.setCountry("India");
        command.setZipCode("380001");
    }

    @Test
    public void testAddMethod() {
        assertNotNull(addressController.add(command));
    }

    @Test
    public void testInvalidFormat(){
        command.setZipCode("");
        assertNull(addressController.add(command));
    }

    @Test
    public void testInvalidCommand(){
        command.setArea("Gota");
        assertNull(addressController.add(command));
    }
}
