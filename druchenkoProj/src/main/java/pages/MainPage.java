package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage{

    public MainPage(WebDriver webDriver) { //конструктор не возвращает значения и называется как класс (создается с помощью Alt + insert)

        super(webDriver);
    }

    public boolean isAvatarPresent(){
        logger.info("Test");
        logger.error("Error");
        logger.debug("Debug");
        try {
           return webDriver.findElement(By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}