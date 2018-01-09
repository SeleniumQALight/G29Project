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
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was open");
        } catch (Exception e) {
            logger.error("Cannot open url");
            Assert.fail("Cannot open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info  (login + "was inputed in to input ");
        } catch (Exception e) {
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
        }
    }



