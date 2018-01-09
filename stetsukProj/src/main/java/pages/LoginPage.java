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
            logger.info("Login page was opened!");
        } catch (Exception e) {
            logger.error("Cannn`t open URL");
            Assert.fail("Cannn`t open URL");
        }
    }

    public void enterTextIntuInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputed into input");
        } catch (Exception e) {
            logger.error("Cannn`t work with element");
            Assert.fail("Cannn`t work with element");
        }
    }
}
