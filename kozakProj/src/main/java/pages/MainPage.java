package pages;


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
        super(webDriver);                            //Супер потрібен для того, щоб він перейшов у парент пейдж
    }

    public boolean isAvatarPresent() {
        return isElementPresent(avatar);  // return - повертає результат метода у boolean
    }

    public void clickOnMenuDictionary() {
        clickOnElement(menuDictionary);
    }

    public void clickOnMenuSpares() {
        clickOnElement(subMenuSpares);
    }


}

