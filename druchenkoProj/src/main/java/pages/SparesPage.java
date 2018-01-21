package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static libs.ActionsWithOurElements.*;


public class SparesPage extends ParentPage{
    @FindBy(xpath = ".//*[@href='" + "http://v3.test.itpmgroup.com/dictionary" + "/spares/edit']")
    private WebElement plusButton;

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy(id = "spares_spareType")
    private WebElement spareType;

    @FindBy(name = "add")
    private WebElement submitSpareButton;


    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButton);
    }

    public void enterTextIntoSpareName(){
        enterTextIntoInput(spareName, "New Spare");
    }

    public void chooseSpareType(){
        selectOptionsInDropDown(spareType, "Механика");
    }

    public void clickOnSubmitSpareButton(){
        clickOnElement(submitSpareButton);
    }

}
