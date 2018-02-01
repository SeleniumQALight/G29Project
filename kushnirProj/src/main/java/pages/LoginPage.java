package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage{
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver,"/login");
    }

    @Step
    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }

    @Step
    public void enterTextIntoInputLogin(String login){
        enterTextInToInput(inputLogin,login);
    }

    @Step
    public void enterTextIntoInputPass(String pass){
        enterTextInToInput(inputPassWord,pass);
    }

    @Step
    public void clickOnSubmitButton(){
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String login, String pass) {
        openLoginPage();
        enterTextIntoInputLogin(login);
        enterTextIntoInputPass(pass);
        clickOnSubmitButton();
    }

    public boolean isLoginInputDisplay() {
        return isElementPresent(inputLogin);
    }
}
