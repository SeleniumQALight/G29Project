package pages;

import static libs.ActionsWithOurElement.*;

import org.junit.Assert;
import org.openqa.selenium.By;
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


    public void openLoginPage() {  //метод що відкриває урл логін пейджи
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");              // пише в лог
        } catch (Exception e) {                                 // відловлює  ексепшени
            logger.error("Can not open url");                    // пише в лог
            Assert.fail("Can not open url ");                    //  пише в отчет про запуск теста
        }
    }

    public void enterTextIntoInputLogin(String login) {      //створили змінну
//        try{
//            inputLogin.clear();                                  //чистимо логін
//            inputLogin.sendKeys(login);                          //водимо логін
//            logger.info(login + " was inputed in to input ");    // пише в лог
//        } catch  (Exception e){                                  // відловлює  ексепшени
//            logger.error("Can not work with element");           // пише в лог
//            Assert.fail("Can not work with element");            //  пише в отчет про запуск теста
//        }   Замінили попередній метод на новий метод з лібс
        enterTextInToInput(inputLogin, login);
    }

    public void enterTextIntoInputPass(String pass) {
        enterTextInToInput(inputPassword, pass);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

}
