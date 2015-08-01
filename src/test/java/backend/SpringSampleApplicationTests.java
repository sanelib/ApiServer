package backend;

import backend.dto.Person;
import backend.dto.validator.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ApplicationSetup}.
 *
 * @author Dave Syer
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles(value = "test")
@SpringApplicationConfiguration(classes = ApplicationSetup.class)
public class SpringSampleApplicationTests {


    @Autowired
    ApplicationContext ctx;


    @Test
    public void testContextLoads() throws Exception {
        assertNotNull(this.ctx);
        assertTrue(this.ctx.containsBean("applicationSetup"));
    }

    @Test
    public void testPersonValidator() throws Exception {

        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));

        Person person = new Person();
        person.setFirstName("fname");
        person.setMiddleName("mname");
        person.setLastName("lname");
        person.setSex("M");
        person.setDateOfBirth("01/01/2000");
        checkValidation(person);
    }

    private boolean checkValidation(Object obj){
        String validatorName = obj.getClass().getSimpleName() + "Validator";
        validatorName = validatorName.replaceFirst(validatorName.substring(0,1), validatorName.substring(0,1).toLowerCase());
        System.out.println(validatorName);
        Validator validator = (Validator) ctx.getBean(validatorName);
        System.out.println(validator.isValid(obj));
        return validator.isValid(obj);
    }

}
