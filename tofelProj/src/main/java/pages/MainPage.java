package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElement.*;

public class MainPage extends ParentPage {
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;
    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spared")
    private WebElement subMenuSpares;

    @FindBy(id = "remember_me")
    private WebElement checkBox;

   // @FindBy(xpath = ".//*[@id='dictionary']/a")
  //  private WebElement dropDown;

  //  @FindBy(className = "fa fa-circle-")
  //  private WebElement dropDownDictionary;


public void clickOnCheckBox(WebElement checkBox){
    clickOnElement(checkBox);
}

    public MainPage(WebDriver webDriver) {
        super(webDriver,"/");// / znachit chto my na  main page
    }

    public boolean isAvatarPresent() {
        return isElementPresent(avatar);
    }
    public void clickOnMenuDictionary(){
        clickOnElement(menuDictionary);
    }
    public void clickOnSubmenuSpare (){
        clickOnElement(subMenuSpares);
    }
}