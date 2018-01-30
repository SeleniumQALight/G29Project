package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWIthOurElements.*;

public class SparesPage extends ParentPage {
    @FindBy (xpath=".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;

    @FindBy (id="spares_spareName")
    private WebElement spareNameInput;

    @FindBy (id="spares_spareType")
    private WebElement spareTypeSelect;

    @FindBy (name="add")
    private WebElement addNewSpareButton;

    @FindBy (name="delete")
    private WebElement deleteSpareButton;


    public SparesPage(WebDriver webDriver) { //здесь было  так: (WebDriver webDriver, String expectedUrl), но так как мы в классе хардкодом
//        прописали урл, поэтому мы ничего не передаем из теста)
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnPlusButton () {
        clickOnElement (plusButton);
    }

    public void addNewSpare (String spareName, String spareType) {
        clickOnPlusButton();
        enterTextInToInput(spareNameInput, spareName);
        selectOptionsInDropDown(spareTypeSelect, spareType);
        clickOnElement(addNewSpareButton);
    }

    public boolean isSparePresent (String spareName) {
        return isStringElementPresent(".//*[text() = '" + spareName + "']");
    }

    public void deleteSpareWhilePresent(String spareName){
        while (isSparePresent(spareName)){
            clickOnElement(webDriver.findElement(By.xpath(".//*[text() = '" + spareName + "']")));
            clickOnElement(deleteSpareButton);
            logger.info ("Spare " + spareName + " was deleted");
        }
    }

}