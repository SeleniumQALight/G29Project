package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElements.*;

public class SpareDictionaryPage extends ParentPage {
    @FindBy(xpath = "//*[@id='spares_spareName']")
    private WebElement spareNameField;

    @FindBy(xpath = "//*[@id='spares_spareType']")
    private WebElement spareDetailTypefield;

    @FindBy(xpath = "//*[@value='4']")
    private WebElement spareDetailTypeElement;

    @FindBy(xpath = "//*[@name='add']")
    private WebElement createButton;

    @FindBy(xpath = "//*[@name='delete']")
    private WebElement deleteButton;


    public SpareDictionaryPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public String enterSpareName () {
        String generatedSpareName = "Savenko`s spare " + generateRandomNumeric(3); //Move to the *AddNewSpareTest* class
        enterTextIntoInput(spareNameField, generatedSpareName);
        return generatedSpareName;
    }

    public void enterSpareDetailType () {
    selectOptionsInDropDown(spareDetailTypefield, spareDetailTypeElement);
    }

    public void clickOnCreateButton () {
    clickOnElement(createButton);
    }

    public void clickOnDeleteButton () {
        clickOnElement(deleteButton);
    }

}
