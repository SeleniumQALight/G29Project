package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;
public class LoginPage extends ParentPage {
    @FindBy(name="_username")
    private WebElement inputLogin;
    @FindBy(id="password")
    private WebElement inputPassword;
    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
        } catch (Exception e) {
            logger.error("Can't open url");
            Assert.fail("Can't open url");
        }
    }

    public void enterTextIntoInputLogin(String login) {
      //  try {
        //    inputLogin.clear();
           // inputLogin.sendKeys("Student");
            // logger.info(login + " was inputted into input");
        // } catch (Exception e) {
           // logger.error("Can't work with element ");
            // Assert.fail("Can't work with element ");
//        }

    enterTextIntoImput(inputLogin, login);
    }

    public void enterTextIntoInputPass (String pass){
        enterTextIntoImput(inputPassword,pass);
            }

            public void clickOnSubmitButton(){
        clickOnElement(buttonSubmit);
            }
}
