package loginTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    // бифо выполняется перед каждой анотацией тест
    @Before
    public void setUP(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    // можно запустить без мейн метода (заимпортить junit)
    @Test
    public void validLogin(){
        webDriver.manage().window().maximize(); //открыли на весь экран браузер
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // неявное ожидание 10 секунд на то что что б браузер развернулся
        webDriver.get("http://v3.test.itpmgroup.com");

    }
    @After                   // закрытие браузера после прохода тестов
    public void tearDown(){
        webDriver.quit();
    }
}
