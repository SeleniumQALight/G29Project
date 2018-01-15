package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElements.*; // import all statics methods from static class

public class MainPages extends ParentPage {

    @FindBy( xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy (id = "dictionary")
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement subMenuSpares;

        public MainPages(WebDriver webDriver) {
        super(webDriver); // take and redirect it to the ParentPage
    }

    public boolean isAvatarPresent () {
        return isElementPresent(avatar) ;
//        logger.info("Test");
//        logger.error("Error");
//        logger.debug("Debug");
//        try {
//        return  webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();
//        }
//        catch ( Exception e) {
//            return false;
//        }
    }

    public void clickOnMenuDictionary () {
            clickOnElement(menuDictionary);
    }
    public void clickOnSubMenuSpares () {
            clickOnElement(subMenuSpares);
    }
}
