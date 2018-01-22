package pages;

import libs.ActionsWithOurElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{

    @FindBy(xpath=".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;
    public void clickOnPlusButton(){
        ActionsWithOurElement.clickOnElement(plusButton);
    }
    public SparesPage(WebDriver webDriver) {


        super(webDriver, "/dictionary/spares");
    }

}
