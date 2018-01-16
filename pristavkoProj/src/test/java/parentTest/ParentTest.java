package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.UserProfile;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected UserProfile userProfile;

    @Before
    public void setUp() {
        File fileFireFox = new File("./driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFireFox.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        String winHandleBefore = webDriver.getWindowHandle();
        webDriver.switchTo().window(winHandleBefore);


        mainPage = new MainPage(webDriver);
        userProfile = new UserProfile(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
