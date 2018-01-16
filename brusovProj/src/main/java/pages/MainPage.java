package pages;

import static libs.ActionsWithOurElements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage{

    @FindBy (xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy (id = "dictionary")
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement subMenuSpares;

    public MainPage(WebDriver webDriver) {
        super(webDriver);

    }

    public boolean isAvatarPresent(){
//        try{
//            return webDriver.findElement(
//                    By.xpath(".//div[@class='pull-left image']//img[@class='img-circle']"))
//                    .isDisplayed();
//        } catch (Exception e){
//            return false;
//        }
       return isElemetPresent(avatar);
    }

    public void clickOnMenuDictionary(){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare(){
        clickOnElement(subMenuSpares);
    }
}

