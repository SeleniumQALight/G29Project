package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthenticationPage;
import pages.MainPage;

import java.io.File;

public class ParentTest {

    public WebDriver webDriver;
    protected MainPage mainPage;
    protected AuthenticationPage authenticationPage;

    @Before
    public void setUp() {
        File fileFireFox = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFireFox.getAbsolutePath());
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        authenticationPage = new AuthenticationPage(webDriver);
    }
// jh
    @After
    public void tearDown() {
        webDriver.quit();
    }

}
