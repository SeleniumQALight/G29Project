package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.isElementPresent;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    @FindBy(xpath = ".//img[@alt='Student']")
    private WebElement avatar;

    @FindBy(id = "dashboard")
    private WebElement menuDashboard;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "service_apparat")
    private WebElement menuServiceApparat;

    @FindBy(id = "installation")
    private WebElement menuInstallation;

    @FindBy(id = "deal")
    private WebElement menuDeal;

    @FindBy(id = "report")
    private WebElement menuReport;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    @FindBy(xpath = ".//span[@class='hidden-xs']")
    private WebElement userProfile;

    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement userLogOutButton;

    public boolean isAvatarPresent() {
        return isElementPresent(avatar);
    }

    public void clickOnMenuDictionary() {
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        clickOnElement(subMenuSpares);
    }

    public void userLogOut(){
        clickOnElement(userProfile);
        clickOnElement(userLogOutButton);
    }

    public boolean isMenuItemsPresent() {
        try {
            boolean mainMenuItemPresent = isElementPresent(menuDashboard);
            boolean dictionaryMenuItemPresent = isElementPresent(menuDictionary);
            boolean serviceMenuItemPresent = isElementPresent(menuServiceApparat);
            boolean installationMenuItemPresent = isElementPresent(menuInstallation);
            boolean dealMenuItemPresent = isElementPresent(menuDeal);
            boolean reportMenuItemPresent = isElementPresent(menuReport);
            boolean isAllMenuPresent = mainMenuItemPresent & dictionaryMenuItemPresent & serviceMenuItemPresent
                    & installationMenuItemPresent & dealMenuItemPresent & reportMenuItemPresent;
            return isAllMenuPresent;
        } catch (Exception e) {
            return false;
        }
    }


}

