package pages;

import static libs.ActionsWithOurElement.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SpareEditPage extends ParentPage {


    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;

     @FindBy(id = "spares_spareType")
    private WebElement sparesTypeDropDown;

    @FindBy(xpath = "//button[@class='btn btn-info']")
    private WebElement addSpareButton;

    @FindBy(name = "delete")
    private WebElement deleteButton;


    public SpareEditPage(WebDriver webDriver, String expectedUrl) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterInputSpareName(String spareName) {
        enterTextInToInput(inputSpareName, spareName);
    }

    public void selectSpareType(String spareType) {
        selectOptionsInDropDown(sparesTypeDropDown, spareType);
    }

    public void clickOnAddButton() {
        clickOnElement(addSpareButton);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }


}
