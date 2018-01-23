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
        super(webDriver,"/login");
    }

    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Login page was open");
        } catch (Exception e) {
            logger.error("Can not open url");
            Assert.fail("Can not open url");
        }
    }

    public void enterTextintoInputLogin(String login) {
//        try{
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputed in to input");
//        }catch (Exception e){
//            logger.error("Can not work with element");
//            Assert.fail("Can not work with element");
//        }
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoInputPsss(String pass){
        enterTextInToInput(inputPassword,pass);
    }

    public void clickOnSubmitButton(){
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String login, String pass){
        openLoginPage();
        enterTextintoInputLogin(login);
        enterTextIntoInputPsss(pass);
        clickOnSubmitButton();
    }
}
