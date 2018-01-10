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

   public WebDriver webDriver;
   protected MainPage mainPage;                                       //доступний тільки у наслідника у всіх папках
   protected LoginPage loginPage;                                     //обявили зміну у якій буде обєкт


    @Before                                                           // це Пре кондішн, відкриває браузер ..Анотація дж-юніта. Виконується перед кожним тесткейсом

    public void setUp() {
        File fileFF = new File("./drivers/chromedriver.exe");         // заімпортили веб драйвер для хрома
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // установлюємо системну змінну, щоб знала шлях до файлу
        webDriver = new ChromeDriver();                               //
        mainPage = new MainPage(webDriver);                           // ініціалізуємо клас MainPage + Дали браузер
        loginPage = new LoginPage(webDriver);                           // ініціалізуємо клас MainPage + Дали браузер

        webDriver.manage().window().maximize();                       // відкрили вікно браузера.розгорнули
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // чекай поки відкриється браузер (макс 10 с.)
    }

    @After
    public void tearDown() {
        webDriver.quit();                          // Закриє браузер
    }

}
