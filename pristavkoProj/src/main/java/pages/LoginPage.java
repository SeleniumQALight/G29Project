package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    final String url = configProperties.base_url();
    final String login = configProperties.user_login();
    final String password = configProperties.user_password();
    final String unvalidPassword = configProperties.wrong_user_password();

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    @FindBy(xpath = ".//*[text()='Авторизация']")
    private WebElement authFormTitle;

    public void openLoginPage() {
        try {
            webDriver.get(url);
            logger.info("Login page was opened " + url);
        } catch (Exception e) {
            logger.error("Can't open url " + url);
            Assert.fail("Can't open url " + url);
        }
    }

    public void enterTextIntoInputLogin(String login) {
        enterTextIntoInput(inputLogin, login);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassWord, password);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public boolean isTitleAuthenticationFormIsPresent() {
        return isElementPresent(authFormTitle);
    }

    public boolean isLoginButtonPresent() {
        return isElementPresent(buttonSubmit);
    }

    public boolean isLoginInputPresent() {
        return isElementPresent(inputLogin);
    }

    public void loginUser() {
        openLoginPage();
        enterTextIntoInputLogin(login);
        enterTextIntoInputPassword(password);
        clickOnSubmitButton();
    }
}

