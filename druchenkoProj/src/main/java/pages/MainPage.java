package pages;

import static libs.ActionsWithOurElements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage{

    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    public MainPage(WebDriver webDriver) { //конструктор не возвращает значения и называется как класс (создается с помощью Alt + insert)
        super(webDriver);
    }

    public boolean isAvatarPresent(){
        return isElementPresent(avatar);
    }

    public void clickOnMenuDictiomary(){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare(){
        clickOnElement(subMenuSpares);
    }

}
