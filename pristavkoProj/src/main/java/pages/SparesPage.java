package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.isElementPresent;

public class SparesPage extends ParentPage {
    final String spareName = "Каляка Маляка";

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement addNewSpare;

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareSelectType;

    @FindBy(xpath = ".//*[@value='4']")
    private WebElement spareSelectValue4;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement createSpareButon;

    @FindBy(xpath = ".//*[text()='Каляка Маляка']")
    private WebElement createdSpareName;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement deleteSpareButton;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void createNewSpare() {
        clickOnElement(addNewSpare);
        actionsWithOurElements.enterTextIntoInput(spareNameInput, spareName);
        actionsWithOurElements.selectOptionsInDropDown(spareSelectType, spareSelectValue4);
        clickOnElement(createSpareButon);
    }

    public void deleteSpare() {
        clickOnElement(createdSpareName);
        clickOnElement(deleteSpareButton);
    }

    public boolean isCreatedSpareIsPresent() {
        return isElementPresent(createdSpareName);
    }

    public boolean isCreatedSparePresetn() {
        return isElementPresent(createdSpareName);
    }


}
