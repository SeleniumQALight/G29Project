package pages;

import libs.ActionsWithOurElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElement.*;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    public WebElement inputLogin;

    @FindBy(id = "password")
    public WebElement inputPassWord;

    @FindBy(tagName = "button")
    public WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    /*public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }
    public void enterTextIntoInputLogin(String login) {
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoInputPass(String pass) {
        enterTextInToInput(inputPassWord, pass);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }*/

    public void loginUser(String login, String pass) {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
        enterTextInToInput(inputLogin, login);
        enterTextInToInput(inputPassWord, pass);
        clickOnElement(buttonSubmit);
    }
}

