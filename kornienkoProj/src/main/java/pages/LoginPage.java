package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage{

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy (tagName = "button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
//        try{
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            //webDriver.findElement(By.name("_username")).clear();
//            //webDriver.findElement(By.name("_username")).sendKeys(login);
//            logger.info(login + " was inputed in to input ");
//        }catch (Exception e){
//            logger.error("Can not work with element ");
//            Assert.fail("Can not  work with element");
//        }
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoToInputPassword(String text) {
        enterTextInToInput(inputPassword, text);
    }

    public void clickOnSubmitButton() {
        clickOnElement(loginButton);
    }
}
