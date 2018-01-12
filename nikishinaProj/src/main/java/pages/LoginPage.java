package pages;

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
        super(webDriver);
    }

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
    public void enterTextIntoInputLogin (String login){
        enterTextInToInput (inputLogin, login);
    }

    public void enterTextIntoInputPass (String pass) {
        enterTextInToInput(inputPassword, pass);
    }

    public void clickOnSubmitButton () {
        clickOnElement(buttonSubmit);
    }
}
