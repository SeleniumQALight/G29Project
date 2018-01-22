package pages;

import Libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Libs.ActionsWithOurElements.clickOnElement;

public class SparesPage extends ParentPage {

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")

    private WebElement plusButton;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButton);
    }
}
