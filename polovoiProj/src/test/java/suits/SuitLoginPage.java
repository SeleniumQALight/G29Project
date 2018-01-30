package suits;

import loginTest.InvalidLogInWithParams;
import loginTest.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                InvalidLogInWithParams.class
        }
)
public class SuitLoginPage {

}
