package pages;

import libs.ActionsWithOurElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElement.*;

public class MainPage extends ParentPage {
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        //  logger.info("Test");
        //  logger.error("Error");
        //  logger.debug("Debug");
        //   try {
        //       return webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();
        //   } catch (Exception e) {
        //       return false;
        //   }
       return isElementPresent(avatar);
    }

    public void clickOnMenuDictionary(){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare(){
        clickOnElement(subMenuSpares);
    }
}

