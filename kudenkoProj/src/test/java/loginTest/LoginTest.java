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

    @Before

    public void setup(){
        File fileFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @Test
    public void validLogin(){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.test.itpmgroup.com");
    }

    @After

    public void tearDown(){
        webDriver.quit();
    }
}
