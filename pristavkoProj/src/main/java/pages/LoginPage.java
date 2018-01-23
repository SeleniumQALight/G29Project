package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    final String url = configProperties.base_url();

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassWord;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    @FindBy(xpath = ".//*[text()='Авторизация']")
    private WebElement authFormTitle;

    @FindBy(xpath = ".//span[@class='hidden-xs']")
    private WebElement userProfile;

    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement userLogOutButton;

    public void openLoginPage() {
        try {
            webDriver.get(url);
            logger.info("Login page was opened " + url);
        } catch (Exception e) {
            logger.error("Can't open url " + url);
            Assert.fail("Can't open url " + url);
        }
    }

    public void validUserLogin(String login, String password) {
        openLoginPage();
        enterTextIntoInput(inputLogin, login);
        enterTextIntoInput(inputPassWord, password);
        clickOnElement(buttonSubmit);
    }

    public void checkLoginFormPresentOnPage() {
        Assert.assertTrue("Title in authentication form isn't present", isElementPresent(authFormTitle));
        Assert.assertTrue("Login input in authentication form isn't present", isElementPresent(buttonSubmit));
        Assert.assertTrue("Button login in authentication form isn't present", isElementPresent(inputLogin));
    }

    public void userLogOut(){
        clickOnElement(userProfile);
        clickOnElement(userLogOutButton);
    }

}

