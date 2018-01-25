package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    String browser = System.getProperty("browser");
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparePage sparePage;
    Logger log;


    @Before

    public void setup(){
        log = Logger.getLogger(getClass());
        setBrowser();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        sparePage = new SparePage(webDriver);

    }

    private void setBrowser() {
        if("chrome".equals(browser)) {
            File fileFF = new File("./drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();
            log.info("chrome started ");
        }else if("mozilla".equals(browser)){
            File fileFF = new File("./drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            webDriver = new FirefoxDriver();
            log.info("mozilla started ");
        }else{
            Assert.fail("Cannot opens browser " + browser);
        }
    }


    @After

    public void tearDown(){
        webDriver.quit();
    }
}
