package pages;

import static libs.ActionsWithOurElement.*;

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

    @FindBy(xpath = ".//*[@class='login-box-body']")
    private WebElement formAutorization;


    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }                                                           // "super" передає значення у батькивський клас


    public void openLoginPage() {                               //метод що відкриває урл логін пейджи
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");               // пише в лог
        } catch (Exception e) {                                 // відловлює  ексепшени
            logger.error("Can not open url");                   // пише в лог
            Assert.fail("Can not open url ");                   //  пише в отчет про запуск теста
        }
    }

    public void enterTextIntoInputLogin(String login) {      //створили змінну
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoInputPass(String pass) {
        enterTextInToInput(inputPassword, pass);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public void loginUser(String login, String pass) {
        openLoginPage();
        enterTextIntoInputLogin(login);
        enterTextIntoInputPass(pass);
        clickOnSubmitButton();
    }

    public boolean authorizationFormIsPresent() {
        return isElementPresent(formAutorization);  // return - повертає результат метода у boolean
    }


}
