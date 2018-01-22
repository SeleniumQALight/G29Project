package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.enterTextIntoInput;
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

    @FindBy(id = "apparat")
    private WebElement subMenuApparat;

    @FindBy(xpath = ".//span[@class='hidden-xs']")
    private WebElement userProfile;

    @FindBy(xpath = ".//a[@href='/logout']")
    private WebElement userLogOutButton;

    @FindBy(xpath = ".//i[@class='fa fa-plus']")
    private WebElement addNewApparatButton;

    @FindBy(id = "apparat_apparatNumber")
    private WebElement apparatNumberInput;

    @FindBy(id = "apparat_apparatComment")
    private WebElement apparatCommentInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement apparatCreateButton;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement apparatDeleteButton;

    @FindBy(xpath = ".//*[text()='Не трогать этот аппарат']")
    private WebElement createdApparatName;

    public boolean isAvatarPresent() {
        return isElementPresent(avatar);
    }

    public void clickOnMenuDictionary() {
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        clickOnElement(subMenuSpares);
    }

    public void clickOnsubMenuApparat() {
        clickOnElement(subMenuApparat);
    }

    public void userLogOut(){
        clickOnElement(userProfile);
        clickOnElement(userLogOutButton);
    }

    public boolean isApparatPresent() {
        return isElementPresent(createdApparatName);
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

    public void createNewApparat(String apparatNumber, String apparatComment){
        clickOnMenuDictionary();
        clickOnsubMenuApparat();
        clickOnElement(addNewApparatButton);
        enterTextIntoInput(apparatNumberInput, apparatNumber);
        enterTextIntoInput(apparatCommentInput, apparatComment);
        clickOnElement(apparatCreateButton);
        logger.info("New apparat created: " + apparatNumber + ", " + apparatComment);
    }

    public void checkNewApparatCreation (String apparatComment) {
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + apparatComment + "']")));
        Assert.assertEquals("Apparat created", apparatComment, apparatCommentInput.getAttribute("value"));
    }

    public void deleteApparat(String apparatComment) {
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + apparatComment + "']")));
        clickOnElement(apparatDeleteButton);
        logger.info("Apparat deleted: " + apparatComment);
    }
}

