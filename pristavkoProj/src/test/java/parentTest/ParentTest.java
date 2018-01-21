package parentTest;

import libs.ActionsWithOurElements;
import libs.WaitTimeWhenLoadingPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;
import pages.UserProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected UserProfile userProfile;
    protected SparesPage sparesPage;
    protected ActionsWithOurElements actionsWithOurElements;
    protected WaitTimeWhenLoadingPage waitTimeWhenLoadingPage;

    @Before
    public void setUp() {
        File fileFireFox = new File("./driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFireFox.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        String winHandleBefore = webDriver.getWindowHandle();
        webDriver.switchTo().window(winHandleBefore);

        loginPage = new LoginPage(webDriver);
        mainPage = new MainPage(webDriver);
        userProfile = new UserProfile(webDriver);
        waitTimeWhenLoadingPage = new WaitTimeWhenLoadingPage();

        // Разобраться, почему тут юзается конструктор
        //sparesPage = new SparesPage(webDriver, "/dictionary/spares");
        sparesPage = new SparesPage(webDriver);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
