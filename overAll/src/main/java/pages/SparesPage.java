package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;

public class SparesPage extends ParentPage{
    private EditSparePage editSparePage;

    @FindBy(xpath = ".//*[@href='" +
            "http://v3.test.itpmgroup.com/dictionary" +
            "/spares/edit']")
    private WebElement plusButton;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButton);
    }

    public boolean isSpareInList(String nameOfSpare){
        return actionsWithOurElements.isElementPresent(".//*[text()='"+nameOfSpare+"']");
    }

    public void clickOnSpare(String nameOfSpare){
        actionsWithOurElements.clickOnElement(".//*[text()='"+nameOfSpare+"']");
    }

    public void deletingSpareUntilPresent(String spareName) {
        while (isSpareInList(spareName)) {
            clickOnSpare(spareName);
            editSparePage.clickOnButtonDelete();
        }
    }
}
