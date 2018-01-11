package pages;

import libs.ActionsWithOurElement;

import static libs.ActionsWithOurElement.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")

    private WebElement inputLogin;

    @FindBy(id = "password")

    private WebElement inputPassword;

    @FindBy(tagName = "button")

    private WebElement buttonSubmit;

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

    public void enterTextInToInputPass(String password) {
        enterTextToInput(inputPassword, password);
    }

    public void enterTextInToInputLogin(String login) {
        enterTextToInput(inputLogin, login);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }
}



