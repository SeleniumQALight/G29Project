package pages;

import static libs.ActionsWithOurElements.*;

import libs.ActionsWithOurElements;
import org.junit.Assert;
//import org.openqa.selenium.By;
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
        super(webDriver);
    }

    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }

    public void enterName(String name){
        enterTextInToInput(inputLogin, name);
//        try {
//            inputLogin.clear();
//            inputLogin.sendKeys(name);
//            logger.info("Login was inputed into input");
//        }catch (Exception e){
//            logger.error("Cannot work with element");
//            Assert.fail("Cannot work with element");
//        }
        }

    public void enterPass(String password){
//        webDriver.findElement(By.id("password")).sendKeys(password);
        enterTextInToInput(inputPassword, password);
    }

    /**
     * Method puts login and password into login page
     * @param login
     * @param pass
     */
    public void loginUser(String login, String pass){
        openLoginPage();
        enterTextInToInput(inputLogin, login);
        enterTextInToInput(inputPassword, pass);
        clickEnter(buttonSubmit);

    }


    public void clickElement(){
//        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        clickOnElement(buttonSubmit);

    }

//    public void enterTextIntoLogin(String login){
//        enterTextInToInput(inputPassword, login);
//    }
//
//    public void enterTextIntoPass(String password){
//        enterTextInToInput(inputPassword, password);
//    }
//
//    public void clicOnSubmitButton(){
//        clickOnElement(buttonSubmit);
//    }
}
