package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;


// здесь будут все тесты, которые будут общие для всех элеиентов
public class ParentTest {
    public WebDriver webDriver;
    String browser=System.getProperty("browser");
    Logger log;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparesPage sparesPage;


    @Before // это нужно для того чтобы открыть браузер, открой нам Хром

    public void setUp() {
        log = Logger.getLogger(getClass());

        setBrowser();
        webDriver.manage().window().maximize();//открывает браузер
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//  время, которое будет работать каждая команда
        mainPage=new MainPage(webDriver);

        mainPage = new MainPage(webDriver);
        loginPage=new LoginPage(webDriver);
        sparesPage =new SparesPage(webDriver);

    }

    private void setBrowser() {
        if (browser==null){
            browser="chrome";
        }
        if ("chrome".equals(browser)) {


            File fileFF = new File("./driver/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

            webDriver = new ChromeDriver();
        } else if ("ie".equals(browser)) {
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
    public void tearDown (){
        webDriver.quit();
    }
}
