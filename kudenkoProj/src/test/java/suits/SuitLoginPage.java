package suits;

import loginTest.LoginTest;
import loginTest.LoginTestDB;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                LoginTestDB.class
        }
)
public class SuitLoginPage {

}
