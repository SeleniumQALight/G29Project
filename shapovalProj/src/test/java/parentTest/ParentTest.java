package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

// eto roditel dlya testov
public class ParentTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;

    // бифо выполняется перед каждой анотацией тест
    @Before
    public void setUP(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); //открыли на весь экран браузер
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // неявное ожидание 10 секунд на выполнения всех команд
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @After                   // закрытие браузера после прохода тестов
    public void tearDown(){
        webDriver.quit();
    }
}
