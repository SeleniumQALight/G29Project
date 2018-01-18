package pages;

import static libs.ActionsWithOurElements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy (id = "spares_spareType")
    private WebElement spareTypeSelect;

    @FindBy(tagName = "button")
    private WebElement createSpareButton;

    public SparePage(WebDriver webDriver){
        super(webDriver, "/dictionary/spares");
    }

    public void clickPlusButton(){
        clickOnElement(plusButton);
    }

    public void enterSpareName(String enteredSpareName){
        enterTextInToInput(spareName, enteredSpareName);
    }

    public void setSpareTypeSelect(String selectDropdawnName){
        selectOptionsInDropDown(spareTypeSelect, selectDropdawnName);
    }

    public void clickCreateSpareButton(){
        clickOnElement(createSpareButton);
    }
}
