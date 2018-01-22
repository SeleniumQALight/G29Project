package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElements.*;



public class SparePage extends ParentPage {

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnAddButton () {
        clickOnElement(plusButton);
    }
}


