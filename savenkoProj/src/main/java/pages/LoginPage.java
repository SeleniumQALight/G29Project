package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openLoginPage () {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info ("Login page was opened");
        }
        catch (Exception e) {
            logger.error("Cannot open the url");
            Assert.fail("Cannot open the url");
        }
    }
    public void enterTextInputLogin (String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputed to the input");
        }
        catch (Exception e) {
            logger.error("Cannot input with the " + login);
            Assert.fail("Cannot input with the " + login);
        }
    }
    public void enterTextInputPassword(String password) {
        webDriver.findElement(By.id("password")).sendKeys("909090");
    }
}
