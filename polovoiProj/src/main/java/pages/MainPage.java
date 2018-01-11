package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElement.*;

public class MainPage extends ParentPage {
    //WebDriver webDriver;
    @FindBy (xpath =".//div[@class='pull-left image']//img[@class='img-circle']" )
    private WebElement avatar;
    @FindBy(id = "dictionary")
    private WebElement menuDictionary;
    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public MainPage(WebDriver webDriver) { //constructor
        super (webDriver);
    }

    public boolean isAvatarPresent() {
     return isElementPresent(avatar);

    }
    public void clickOnMenuDictionary(){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares(){
        clickOnElement(subMenuSpares);
    }
}


