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
        } catch (Exception e) {
            logger.error("Can't open url");
            Assert.fail("Can't open url");
        }
    }

    public boolean isMenuItemMainPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='/dashboard']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void enterTextIntoInputLogin(String login) {
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(login);
            logger.info(login + " was inputed into login input ");
        } catch (Exception e) {
            logger.error("Can't work with element ");
            Assert.fail("Can't work with element");
        }
    }

    public void enterTextIntoInputPassword(String password) {
        try {
            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys(password);
            logger.info(password + " was inputed into password input ");
        } catch (Exception e) {
            logger.error("Can't work with element ");
            Assert.fail("Can't work with element");
        }
    }

    public boolean isTitleAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isButtonLoginInAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//button[@type='submit']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

}

