package backend;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/*
* Date:16th July 2015
* Making test case for checking of beans
*/

public class CheckValidBeanTest extends ContextProviderTest {

    @Test
    public void testContextLoads() throws Exception {
        assertNotNull(this.ctx);
        assertTrue(this.ctx.containsBean("applicationSetup"));
    }
}
