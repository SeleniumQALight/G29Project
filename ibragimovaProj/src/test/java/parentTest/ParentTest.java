package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

// здесь будут все тесты, которые будут общие для всех элеиентов
public class ParentTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparesPage sparesPage;


    @Before // это нужно для того чтобы открыть браузер, открой нам Хром

    public void setUp() {
        File fileFF = new File("./driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();//открывает браузер
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//  время, которое будет работать каждая команда
        mainPage=new MainPage(webDriver);

        mainPage = new MainPage(webDriver);
        loginPage=new LoginPage(webDriver);
        sparesPage =new SparesPage(webDriver);
    }
    @After
    public void tearDown (){
        webDriver.quit();
    }
}
