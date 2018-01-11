package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParenTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;

    @Before
    public void setUp(){
        File fileFF = new File("kornienkoProj/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
