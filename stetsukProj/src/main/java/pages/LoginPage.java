package pages;

import libs.ActionsWithoutElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputePassword;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
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

    public void enterTextIntuInputLogin(String login) {
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputed into input");
//        } catch (Exception e) {
//            logger.error("Cannn`t work with element");
//            Assert.fail("Cannn`t work with element");
//        }
        ActionsWithoutElements.enterTextInToInput(inputLogin, login);
    }

    public void entetTextInToInputePass(String pass){
        ActionsWithoutElements.enterTextInToInput(inputePassword, pass);
    }

    public void clickOnSubmitElement(){
        ActionsWithoutElements.clickOnElement(buttonSubmit);
    }

}
