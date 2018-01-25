package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElement.*;

public class SparesPage extends ParentPage {

    @FindBy(xpath =".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']" )
    private WebElement plusButton;

    @FindBy (xpath = "//*[contains(text(), 'Kozak test')] |//*[contains(text(), 'самолет')]")
    private WebElement nameAddedSpare;

    public SparesPage (WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButton);
    }

    public void clickOnNameOfAddedSpare(){
        clickOnElement(nameAddedSpare);
    }

}
