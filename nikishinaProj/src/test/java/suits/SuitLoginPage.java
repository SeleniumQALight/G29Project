package suits;

import loginTest.InvalidLoginWithParams;
import loginTest.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                InvalidLoginWithParams.class
        }
)
public class SuitLoginPage {
}
