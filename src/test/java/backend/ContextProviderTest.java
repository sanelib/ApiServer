package backend;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationSetup.class)
/*
* Date:16th July 2015
* Defining abstract class which provides ApplicationContext
*/

abstract class ContextProviderTest {

    @Autowired
    protected ApplicationContext ctx;
}
