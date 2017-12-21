package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage{

    public MainPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isAvatarPresent(){
        logger.info("Test");
        logger.error("Error");
        logger.debug("Debug");
        try{
           return  webDriver.findElement(By.xpath(".//img[@class='user-image']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
