package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    //забираем бефор блок из логинтеста и обїявление переменной ввебдрайвера
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected LoginPage loginPage;


    @Before //это аннотация junit: бефор говорит, что этот метод надо выполнить перед каждым тестом
    public void setUp (){
        File fileFF = new File("./drivers/chromedriver.exe");//скачали экзешник
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());// устанавливаем системную переменную, откуда стартовать хром
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); //раскрываем окно браузера фулсайз
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //общая настройка неявное ожидание,
        // в течение 10-ти секунд пытайся что-то сделать, если получится иди сразу дальше

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
    }

    @After //тоже аннотация
    public void tearDown(){ //закрытие браузера
        webDriver.quit(); // если написать этот мптод после метода гет, то в каждом тесте прийдется это писать. а еще
        //если упадет эксепшен в методе под аннотацией тест, то браузер закроется и мы ен узнаем, какая ошибка возникла
        }

}
