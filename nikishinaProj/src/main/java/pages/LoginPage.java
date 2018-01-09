package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e){
            logger.error("Can not open url");
            Assert.fail("Can not open url"); //останавливает тест полностью, если упадет такая ошибка
        }
    }

    public void enterTextIntoInputLogin (String login){
        try{
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputed into input ");
        }catch (Exception e){
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element");
        }
    }
}
