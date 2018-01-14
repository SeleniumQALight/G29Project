package pages;

import static libs.ActionsWithOurElements.*;

import libs.ActionsWithOurElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.event.WindowEvent;

public class MainPage extends ParentPage{

    @FindBy(xpath = ".//img[@class='user-image']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public MainPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isAvatarPresent(){
//        logger.info("Test");
//        logger.error("Error");
//        logger.debug("Debug");
//        try{
//           return  webDriver.findElement(By.xpath(".//img[@class='user-image']")).isDisplayed();
//        }catch (Exception e){
//            return false;
//        }
       return isElementPresent(avatar);
    }

    public void clickOnMenuDictionary(){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMuneSpare(){
        clickOnElement(subMenuSpares);
    }


}
