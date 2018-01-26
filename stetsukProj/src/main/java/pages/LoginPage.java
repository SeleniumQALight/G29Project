package pages;

import static libs.ActionsWithoutElements.*;

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
            logger.info("Login page was opened!");
        } catch (Exception e) {
            logger.error("Cannn`t open URL");
            Assert.fail("Cannn`t open URL");
        }
    }

    /**
     * @param login
     * @param pass
     */
    public void loginUser(String login, String pass) {
        this.openLoginPage();
        enterTextInToInput(inputLogin, login);
        enterTextInToInput(inputPassword, pass);
        clickOnElement(buttonSubmit);
    }

    /**
     * @return
     */
    public boolean isLoginPresent() {
        return isElementPresent(inputLogin);
    }

}
