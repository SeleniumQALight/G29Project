package logintest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author oleksandr.brusov
 * @date 14.12.2017.
 */
public class LoginTest {
    WebDriver webDriver;

    @Before
    public  void setUp(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        webDriver = new ChromeDriver();
    }

    @Test
    public void vallidLogin(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com/login");
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}

