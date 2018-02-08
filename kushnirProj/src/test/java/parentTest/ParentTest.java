package parentTest;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import pages.MainPage;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
public class ParentTest {
    public WebDriver webDriver;
    String browser = System.getProperty("browser");
    Logger log;
    protected MainPage mainPage;
    protected LoginPage loginPage;




    @Before
    public void setUp() {
        log = Logger.getLogger(getClass());
        setBrowser();
        webDriver.manage().window().maximize();//открыли на весь экран. скажи менеджеру повлиять на окошко
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//время, на протяжении которого будет пытаться что-то сделать
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    private void setBrowser() {

        if (browser==null){
            browser="chrome";
        }
        if ("chrome".equals(browser)) {

            File fileFF = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();//метод нужно выполнить раньше
        }else if ("ie".equals(browser)){
            log.info("IE will be started");
            File file1 = new File(".././drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            log.info(" IE is started");
        }else {
            Assert.fail("Can not open browser"+browser);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit();//закрываем метод
    }

    @Step
    protected void checkAC(String message, Boolean actual, Boolean expected) {
        Assert.assertEquals(message + "Browser - " + browser + "  " ,  actual, expected);
    }
}
