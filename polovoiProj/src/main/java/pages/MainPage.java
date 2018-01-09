package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage {
    //WebDriver webDriver;

    public MainPage(WebDriver webDriver) { //constructor
        super (webDriver);
    }

    public boolean isAvatarPresent() {
        logger.info("Test");
        logger.error("Error");
        logger.debug("Debug");
        try {
            return webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}


