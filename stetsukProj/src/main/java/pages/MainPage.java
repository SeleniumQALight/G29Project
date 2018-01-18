package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithoutElements.*;

public class MainPage extends ParentPage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "installation")
    private WebElement installationItem;

    @FindBy(xpath = ".//*[@id='device_list']/tbody/tr[1]")
    private WebElement installationFirstElementItem;

    @FindBy(id = "spare")
    private WebElement subMenuSpare;

    @FindBy(xpath = "html/body/div[1]/div/section[2]/div[2]/div/div/div[1]/div/a/i")
    private WebElement installationAddAdd;

    @FindBy(id = "installed_spares_lastSpareIsGood")
    private WebElement installationSpares;

    public boolean isAvatarPresent() {
        return isElementPresent(avatar);
    }

    public void clicOnMenuDictionary() {
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare() {
        clickOnElement(subMenuSpare);
    }

    public void clickOnMenuinstallation() {
        clickOnElement(installationItem);
    }

    public void clickOnInstallationFirstElementItem() {
        clickOnElement(installationFirstElementItem);
    }

    public void clickOnInstallationAddAdd() {
        clickOnElement(installationAddAdd);
    }

    public void clickOnInstallationSpares() {
        setStateToCheckBox(installationSpares, "check");
    }

}
