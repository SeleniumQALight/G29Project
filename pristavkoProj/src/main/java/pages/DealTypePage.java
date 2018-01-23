package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class DealTypePage extends ParentPage {
    protected MainPage mainPage;


    public DealTypePage (WebDriver webDriver) {
        super(webDriver, "/dictionary/deal_type");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "deal_type")
    private WebElement subMenuDealType;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement dealTypeCreateButton;

    @FindBy(id = "deal_type_dealTypeName")
    private WebElement dealTypeNameInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement providerSaveButton;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement providerDeleteButton;

    @FindBy(xpath = ".//*[text()='11111']")
    private WebElement providerName;



}

