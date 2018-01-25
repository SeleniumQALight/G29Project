package pages;

import libs.ActionsWithOurElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPageEdit extends ParentPage {
    @FindBy(xpath = ".//*[@id='spares_spareName']")
    private WebElement newSpareNameInput;

    @FindBy(xpath = ".//*[@name='add']")
    private WebElement newSpareAddButton;

    @FindBy(xpath = ".//*[@id='spares_spareType']")
    private WebElement tipDetaliInput;

    @FindBy(xpath = ".//*[@class='btn btn-danger pull-right']")
    private WebElement newSpareDelete;



    public SparesPageEdit(WebDriver webDriver, String expectedUrl) {
        super(webDriver, "/dictionary/spares/edit");
    }


    public void enterTextIntoNewSpareNameInput(String spareName) {
        ActionsWithOurElement.enterTextInToInput(newSpareNameInput, spareName);
    }

    public void enterTextIntoTipDetaliDropDown(String tipDetali) {
        ActionsWithOurElement.selectOptionInDropDown(tipDetaliInput, tipDetali);}


    public void clickOnAddNewSpareButton() {
        ActionsWithOurElement.clickOnElement(newSpareAddButton); }

}


