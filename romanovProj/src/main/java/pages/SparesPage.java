package pages;

import libs.ActionsWithOurElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;

public class SparesPage extends ParentPage{
    @FindBy(xpath = ".//*[@href=href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButon;
    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButon);
    }
}
