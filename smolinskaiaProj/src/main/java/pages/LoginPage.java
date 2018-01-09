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
        } catch (Exception e) {
            logger.error("Can't open url");
            Assert.fail("Can't open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys("Student");
            logger.info(login + " was inputted into input");
        } catch (Exception e) {
            logger.error("Can't work with element ");
            Assert.fail("Can't work with element ");
        }
    }
}
