package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWIthOurElements.*;

public class LoginPage extends ParentPage {
    @FindBy (name = "_username")
    private WebElement inputLogin;

    @FindBy (id="password")
    private WebElement inputPassword;

    @FindBy (tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login"); // вставляем относительный путь к логин пейдже - /login
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        } catch (Exception e){
            logger.error("Can not open url");
            Assert.fail("Can not open url"); //останавливает тест полностью, если упадет такая ошибка
        }
    }

//    Сначала, до создания ActionsWithOurElements метод ввода текста выглядел так:
//    public void enterTextIntoInputLogin (String login){
//        try{
//            //webDriver.findElement(By.name("_username")).clear(); -- сначала было так, но ниже оптимизируем:
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputed into input ");
//        }catch (Exception e){
//            logger.error("Can not work with element ");
//            Assert.fail("Can not work with element");
//        }

//    После рефакторинга он выглядит так:
    @Step
    public void enterTextIntoInputLogin (String login){
        enterTextInToInput (inputLogin, login);
    }

    @Step
    public void enterTextIntoInputPass (String pass) {
        enterTextInToInput(inputPassword, pass);
    }

    @Step
    public void clickOnSubmitButton () {
        clickOnElement(buttonSubmit);
    }

//    В LoginPage реализовать метод, который бы с помощью вызова уже реализованых выпослнял следующее: открывал логин Пейдж, вводил логин, вводил пароль и сликал кнопку
//    public void loginUser(String login, String pass)
    public void loginUser (String login, String pass) {
        openLoginPage();
        enterTextIntoInputLogin(login);
        enterTextIntoInputPass(pass);
        clickOnSubmitButton();
    }
}
