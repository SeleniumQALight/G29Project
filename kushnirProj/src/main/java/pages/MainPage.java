package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//если мы хотим найти аватарку на мейнпейдже, значит мы его разрабатываем
//если есть класс, описывающий пейджу, описываем пейджу
//если нет, значит нет нигде
public class MainPage extends ParentPage {


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }



    public boolean isAvatarPresent() {
        logger.info("Test");
        logger.error("Error");
        logger.debug("Debug");
        try {
            return webDriver.findElement(
                    By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']")).isDisplayed();//если експешн - викинет катч

        } catch (Exception e) {
            return false;
        }
    }

}
