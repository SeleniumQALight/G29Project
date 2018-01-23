package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.clickOnElement;
import static libs.ActionsWithOurElements.enterTextInToInput;
import static libs.ActionsWithOurElements.selectOptionsInDropDown;

public class SparesPage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;
    @FindBy(name = "spares[spareName]")
    private WebElement spareName;
    @FindBy(name = "spares[spareType]")
    private WebElement spareDropDown;
    @FindBy(name = "add")
    private WebElement addNewSpare;
    @FindBy (name = "delete")
    private WebElement deleteSpare;



    public void clickOnPlusButton() {
        clickOnElement(plusButton);
    }

    public void addSpareAndDelete(String nameOfSpare, String nameOfCategory) {
        enterTextInToInput(spareName, nameOfSpare);
        selectOptionsInDropDown(spareDropDown, nameOfCategory);
        clickOnElement(addNewSpare);
        String elementXPath = String.format(".//*[@id='device_list']/tbody/tr/td[text()='%s'] ", nameOfSpare);
        WebElement element = webDriver.findElement(By.xpath(elementXPath));
        clickOnElement(element);
        clickOnElement(deleteSpare);
    }
    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

}
