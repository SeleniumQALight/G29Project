package pages;

import static libs.ActionsWithOurElements.*;

import org.junit.Assert;
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
        super(webDriver, "/login");
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
        enterTextIntoInput(inputLogin, login);
    }

    public void enterPassIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String login, String pass) {
        openLoginPage();
        enterTextIntoInputLogin(login);
        enterPassIntoInputPassword(pass);
        clickOnSubmitButton();
    }
}
