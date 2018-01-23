package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class ApparatPage extends ParentPage {
    protected MainPage mainPage;


    public ApparatPage(WebDriver webDriver) {
        super(webDriver, "/");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "apparat_apparatComment")
    private WebElement apparatCommentInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement apparatCreateButton;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement apparatDeleteButton;

    @FindBy(xpath = ".//*[text()='Не трогать этот аппарат']")
    private WebElement createdApparatName;

    @FindBy(xpath = ".//i[@class='fa fa-plus']")
    private WebElement addNewApparatButton;

    @FindBy(id = "apparat_apparatNumber")
    private WebElement apparatNumberInput;

    public void createNewApparat(String apparatNumber, String apparatComment) {
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnsubMenuApparat();
        clickOnElement(addNewApparatButton);
        enterTextIntoInput(apparatNumberInput, apparatNumber);
        enterTextIntoInput(apparatCommentInput, apparatComment);
        clickOnElement(apparatCreateButton);
        logger.info("New apparat created: " + apparatNumber + ", " + apparatComment);
    }

    public boolean isApparatPresent() {
        return isElementPresent(createdApparatName);
    }

    public void deleteAllApparatWhenTheyArePresent(String apparatComment) {
        while (isApparatPresent() == true) {
            deleteApparat(apparatComment);
        }
    }

    public void checkNewApparatCreation(String apparatComment) {
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + apparatComment + "']")));
        Assert.assertEquals("Apparat created", apparatComment, apparatCommentInput.getAttribute("value"));
    }

    public void deleteApparat(String apparatComment) {
        clickOnElement(webDriver.findElement(By.xpath(".//*[text()='" + apparatComment + "']")));
        clickOnElement(apparatDeleteButton);
        logger.info("Apparat deleted: " + apparatComment);
    }

}

