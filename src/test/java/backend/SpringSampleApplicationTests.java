package backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        assertTrue(this.ctx.containsBean("profileServiceImpl"));
        assertTrue(this.ctx.containsBean("applicationSetup"));
    }

}
