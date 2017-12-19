package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.io.File;

public class ParentClass {

   public WebDriver webDriver;
   protected MainPage mainPage;

    @Before
    public void setUp() {
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        mainPage=new MainPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
