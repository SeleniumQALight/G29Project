package parentTest;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import pages.LoginPage;
import pages.MainPage;
import pages.SparePage;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    String browser = System.getProperty("browser");
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparePage sparePage;
    Logger log;
   protected Boolean isTestSuccess;
   String errorPath;


    @Rule
    public TestRule testWatcher = new TestWatcher() {
        @Override
        public void starting(Description test){
            errorPath = test.getTestClass().getPackage() + "_" + test.getTestClass() + "_" + test.getMethodName();
    }};


    @Before

    public void setup(){
        log = Logger.getLogger(getClass());
        setBrowser();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        sparePage = new SparePage(webDriver);

        isTestSuccess = false;

    }

    private void setBrowser() {
        if(browser == null){
            browser = "chrome";
        }
        if("chrome".equals(browser)) {
            File fileFF = new File("./drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();
            log.info("chrome started ");
        }else if("mozilla".equals(browser)){
            File fileFF = new File("./drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            webDriver = new FirefoxDriver();
            log.info("mozilla started ");
        }else{
            Assert.fail("Cannot opens browser " + browser);
        }
    }




    @After

    public void tearDown(){
        if(!isTestSuccess) {
            makeScreenshot();
        }
        webDriver.quit();
    }

    private void makeScreenshot(){
        File screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Date date = new Date();
            File file = new File("./target/screenshots");
            if(!file.exists()){
                file.mkdir();
            }
            File screenshotLocation = new File("./target/screenshots/screen_" + date.getTime() + "_" +
            errorPath + "_" +  browser + ".png");
            FileHandler.copy(screenshot, screenshotLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Step
    protected void checkAC(String message, Boolean actual, Boolean expected) {
        Assert.assertEquals(message + "Browser - " + browser + " " ,  actual, expected);
    }

}