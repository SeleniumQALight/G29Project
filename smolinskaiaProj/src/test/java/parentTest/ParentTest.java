package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static pages.ParentPage.configProperties;

public class ParentTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparesPage sparesPage;

    @Before
    public void setUp(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        sparesPage = new SparesPage(webDriver);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
