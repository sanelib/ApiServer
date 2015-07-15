package backend;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link backend.ApplicationSetup}.
 */
public class SampleApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private String profiles;

    @Before
    public void init() {
        this.profiles = System.getProperty("spring.profiles.active");
        System.out.println("Profile init:" + this.profiles);
    }

    @After
    public void after() {
        if (this.profiles != null) {
            System.setProperty("spring.profiles.active", this.profiles);
        }
        else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultSettings() throws Exception {
        ApplicationSetup.main(new String[0]);

        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("name: Production"));
    }

    @Test
    public void testExplicitVariable() throws Exception {
        ApplicationSetup.main(new String[] { "--name=Gordon" });
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("name: Gordon"));
    }

    @Test
    public void testDevProfile() throws Exception {
        System.setProperty("spring.profiles.active", "dev");
        ApplicationSetup.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("name: Developer"));
    }

    @Test
    public void testProfileCommand() throws Exception {
        ApplicationSetup.main(new String[]{"--spring.profiles.active=dev"});
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("name: Developer"));
    }
}