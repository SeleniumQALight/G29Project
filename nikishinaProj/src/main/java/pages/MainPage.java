package pages;
//здесь должны быть описаны все элементы, находящиеся на странице main page
//если здесь не будет метода, описывающий какой-то из элементов страницы, то этого метода нет нигде, и его надо дописать здесь

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWIthOurElements.*;

public class MainPage extends ParentPage {
    //WebDriver webDriver;
    //создадим конструктор: конструктор не возвращает значений в отличие от обычных методов и его название соответствует
    //названию класса

    @FindBy (xpath=".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy (id="dictionary")
    private WebElement menuDictionary;

    @FindBy (id="spares")
    private WebElement subMenuSpares;

    public MainPage (WebDriver webDriver) {
        super(webDriver);
    }

    //опишем метод, который ищет аватарку, и что делать, если ее не нашел: вебдрайвер найди элемент аватарку
    public boolean isAvatarPresent () {
        return isElementPresent(avatar);
    }

    public void clickOnMenudictionary (){
        clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare (){
        clickOnElement(subMenuSpares);
    }


}


