package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*; // import all statics methods from static class


public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open the url");
            Assert.fail("Cannot open the url");
        }
    }

    public void enterTextInputLogin(String login) {
        enterTextIntoInput(inputLogin, login);
    }

    public void enterTextInputPassword(String password) {
        enterTextIntoInput(inputPassWord, password);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String login, String pass) {

        openLoginPage();
        enterTextInputLogin(login);
        enterTextInputPassword(pass);
        clickOnSubmitButton();
    }
}
