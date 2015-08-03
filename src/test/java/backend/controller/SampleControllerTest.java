package backend.controller;

import backend.BaseTest;
import backend.dto.Address;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by zaidikkis on 01-Aug-15.
 */
public class SampleControllerTest extends BaseTest{

    @Autowired
    private SampleController controller;

    Address dto = new Address();

    @Before
    public void setUp(){
        dto.setLine1("Line1");
        dto.setLine2("Line2");
        dto.setArea("Gota");
        dto.setState("Gujarat");
        dto.setCity("Ahmedabad");
        dto.setCountry("India");
        dto.setZipCode("380001");
    }

    @Test
    public void testDtoToCommandMapping(){
        assertTrue(controller.mapping(dto));
    }

    @Test
    public void testInvalidFormatDtoToCommandMapping(){
        dto.setZipCode("Three");
        assertFalse(controller.mapping(dto));
    }
}
