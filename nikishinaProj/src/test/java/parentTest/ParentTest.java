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

public class ParentTest {
    //забираем бефор блок из логинтеста и обїявление переменной ввебдрайвера
    public WebDriver webDriver;
//    создаем стринговую переменную браузер, в которую будет передаваться стринга:
    String browser = System.getProperty("browser");
    Logger log; //мы объявили его с дефолтным идентификатором доступа, соответственно он будет доступен в этом классе, в его наследниках и только в этом пекедже
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparesPage sparesPage;

    //        сделаем параметризированный запуск тестов в разных браузерах
    @Before //это аннотация junit: бефор говорит, что этот метод надо выполнить перед каждым тестом
    public void setUp (){
        log = Logger.getLogger(getClass());
        setBrowser();
        webDriver.manage().window().maximize(); //раскрываем окно браузера фулсайз
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //общая настройка неявное ожидание,
        // в течение 10-ти секунд пытайся что-то сделать, если получится иди сразу дальше

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        sparesPage = new SparesPage(webDriver);
    }

//    у нас было три строки, мы их выделили: правая мышь -> refactor -> method -> задали имя метода setBrowser -> ok
//private void setBrowser() {
//    File fileFF = new File("./drivers/chromedriver.exe");//скачали экзешник
//    System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());// устанавливаем системную переменную, откуда стартовать хром
//    webDriver = new ChromeDriver();
//    после этого создался метод с заданным именем и вынесся сюда вниз, а вверху осталось только название метода setBrowser ();
//    теперь дополним метод необходимыми условиями:

    private void setBrowser() {
        if (browser == null){
            browser="chrome";
        }

        if ("chrome".equals(browser)) {
            File fileFF = new File("./drivers/chromedriver.exe");//скачали экзешник
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());// устанавливаем системную переменную, откуда стартовать хром
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
        } else {
            Assert.fail("Can not open browser " + browser);
        }
    }

    @After //тоже аннотация
    public void tearDown(){ //закрытие браузера
        webDriver.quit(); // если написать этот мптод после метода гет, то в каждом тесте прийдется это писать. а еще
        //если упадет эксепшен в методе под аннотацией тест, то браузер закроется и мы ен узнаем, какая ошибка возникла
        }

}
