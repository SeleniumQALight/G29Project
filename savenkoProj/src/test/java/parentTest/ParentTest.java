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
import pages.MainPages;
import pages.SpareDictionaryPage;
import pages.SparePage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    public Logger log;
    String browser = System.getProperty("browser"); //name of browser for launch
    protected MainPages mainPage;                                       //доступний тільки у наслідника у всіх папках
    protected LoginPage loginPage;
    protected SparePage sparePage;
    protected SpareDictionaryPage spareDictionaryPage;

    @Before                                                           // це Пре кондішн, відкриває браузер ..Анотація дж-юніта. Виконується перед кожним тесткейсом

    public void setUp() {
        log = Logger.getLogger(getClass());
        setBrowser();

        mainPage = new MainPages(webDriver);                           // ініціалізуємо клас MainPage + Дали браузер
        loginPage = new LoginPage(webDriver);
        sparePage = new SparePage(webDriver);
        spareDictionaryPage = new SpareDictionaryPage (webDriver);


        webDriver.manage().window().maximize(); //open window full screen
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    }

    private void setBrowser() {
        if ("chrome".equals(browser)) {
            File fileFF = new File("./drivers/chromedriver.exe");         // заімпортили веб драйвер для хрома
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // установлюємо системну змінну, щоб знала шлях до файлу
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
            Assert.fail("Can not open browser " + browser);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit(); // Закриє браузер
    }

}