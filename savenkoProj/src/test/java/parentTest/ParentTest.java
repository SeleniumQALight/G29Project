package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPages;
import pages.SpareDictionaryPage;
import pages.SparePage;


import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    protected MainPages mainPage;                                       //доступний тільки у наслідника у всіх папках
    protected LoginPage loginPage;
    protected SparePage sparePage;
    protected SpareDictionaryPage spareDictionaryPage;

    @Before                                                           // це Пре кондішн, відкриває браузер ..Анотація дж-юніта. Виконується перед кожним тесткейсом

    public void setUp() {
        File fileFF = new File("./drivers/chromedriver.exe");         // заімпортили веб драйвер для хрома
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // установлюємо системну змінну, щоб знала шлях до файлу
        webDriver = new ChromeDriver();                               //
        mainPage = new MainPages(webDriver);                           // ініціалізуємо клас MainPage + Дали браузер
        loginPage = new LoginPage(webDriver);
        sparePage = new SparePage(webDriver);
        spareDictionaryPage = new SpareDictionaryPage (webDriver);


        webDriver.manage().window().maximize(); //open window full screen
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    }

    @After
    public void tearDown() {
        webDriver.quit(); // Закриє браузер
    }

}