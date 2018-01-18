package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;


    public LoginPage(WebDriver webDriver) {
        super(webDriver,"/login");
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not opet url");
            Assert.fail("Can not opet url");
        }

    }

    public void enterTextIntoInputLogin(String login) {
/*        try {
            inputLogin.clear();
            inputLogin.sendKeys(login);
            logger.info(login + " was inputed in input");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }*/
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoInputPass(String pass){
        enterTextInToInput(inputPassWord,pass);
    }

    public void clickOnSubmitButton(){
        clickOnElement(buttonSubmit);

    }
}


