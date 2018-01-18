package pages;

import static libs.ActionsWithOurElements.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    final String url = "http://v3.test.itpmgroup.com/login";
    final String login = "Student";
    final String password = "909090";
    final String unvalidPassword = "906090";

    public String getUnvalidPassword() {
        return unvalidPassword;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public void openLoginPage() {
        try {
            webDriver.get(url);
            logger.info("Login page was opened " + url);
        } catch (Exception e) {
            logger.error("Can't open url " + url);
            Assert.fail("Can't open url " + url);
        }
    }

    public boolean isMenuItemMainPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='/dashboard']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void enterTextIntoInputLogin(String login) {
/*   Так было раньше до использования ActionsWithOurElements
        try {
            inputLogin.clear();
            inputLogin.sendKeys(login);
            logger.info(login + " was inputed into login input ");
        } catch (Exception e) {
            logger.error("Can't work with element ");
            Assert.fail("Can't work with element");
        }*/

        enterTextIntoInput(inputLogin, login);
    }

    public void enterTextIntoInputPassword(String password) {
/*   Так было раньше до использования ActionsWithOurElements
        try {
            webDriver.findElement(By.id("password")).clear();
            webDriver.findElement(By.id("password")).sendKeys(password);
            logger.info(password + " was inputed into password input ");
        } catch (Exception e) {
            logger.error("Can't work with element ");
            Assert.fail("Can't work with element");
        }*/
        enterTextIntoInput(inputPassWord, password);
    }

    public void clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
    }

    public boolean isTitleAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isButtonLoginInAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//button[@type='submit']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginInputDisplay() {
        return isElementPresent(inputLogin);
    }

    public void loginUser(String login, String password) {
        openLoginPage();
        enterTextIntoInputLogin(getLogin());
        enterTextIntoInputPassword(getPassword());
        clickOnSubmitButton();
    }

}

