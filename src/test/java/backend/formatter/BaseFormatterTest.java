package backend.formatter;

import backend.ApplicationSetup;
import backend.BaseTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Z21 on 01-Aug-15.
 */

public abstract class BaseFormatterTest extends BaseTest{

    //TODO need to make this generic instead of Object
    public abstract boolean checkFormat(Object obj);
}
