package pages;

import libs.ActionsWithOurElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElement.*;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPass;

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
            logger.error("Can not open url");
            org.junit.Assert.fail("Can not open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
        //      try {
        //          inputLogin.clear();
        //          inputLogin.sendKeys(login);
        //          logger.info(login + " was inputed in to input");
        //      } catch (Exception e) {
        //          logger.error("Can not work with element");
        //          org.junit.Assert.fail("Can not work with element");
        //      }
        enterTextIntoInput(inputLogin, login);
    }

    public void enterTextIntoInputPass(String pass){
        enterTextIntoInput(inputPass, pass);
    }

    public void clickOnSubmitButton(){
        clickOnElement(buttonSubmit);

    }

}