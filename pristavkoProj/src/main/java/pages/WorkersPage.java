package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class WorkersPage extends ParentPage {
    protected MainPage mainPage;


    public WorkersPage (WebDriver webDriver) {
        super(webDriver, "/dictionary/workers");
        mainPage = new MainPage(webDriver);
    }

    @FindBy(id = "workers")
    private WebElement subMenuWorkers;

    @FindBy(xpath = ".//*[@data-toggle='tooltip']")
    private WebElement workerCreateButton;

    @FindBy(id = "workers_workerSurname")
    private WebElement workerSurnameInput;

    @FindBy(id = "workers_workerName")
    private WebElement workerNameInput;

    @FindBy(id = "workers_workerMiddleName")
    private WebElement workerMidInput;

    @FindBy(id = "workers_workerPhone")
    private WebElement workerPhoneInput;

    @FindBy(xpath = ".//button[@name='add']")
    private WebElement workerSaveButton;

    @FindBy(xpath = ".//*[text()='Петренко Петр Николаевич']")
    private WebElement worker;

    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement workerDeleteeButton;

}

