package pages;

import static libs.ActionsWithOurElements.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    private WebElement plusButton;

    @FindBy(id = "spares_spareName")
    private WebElement spareName;

    @FindBy (id = "spares_spareType")
    private WebElement spareTypeSelect;

    @FindBy(tagName = "button")
    private WebElement createSpareButton;

    @FindBy(name = "delete")
    private WebElement deleteSpareButton;

    public SparePage(WebDriver webDriver){
        super(webDriver, "/dictionary/spares");
    }

    public void clickPlusButton(){
        clickOnElement(plusButton);
    }

    public void enterSpareName(String enteredSpareName){
        enterTextInToInput(spareName, enteredSpareName);
    }

    public void setSpareTypeSelect(String selectDropdawnName){
        selectOptionsInDropDown(spareTypeSelect, selectDropdawnName);
    }

    public void clickCreateSpareButton(){
        clickOnElement(createSpareButton);
    }

    public boolean createdSparePresent(String spareName){
        try {
            return isElementPresent(webDriver.findElement(By.xpath(".//*[@id='device_list']/tbody/tr/td[contains(text(),'" + spareName + "')]")));
        }catch (Exception e){
            logger.info(spareName + " spare wasn't founded");
            return  false;
        }
    }

    public void clickOnCreatedSpare(String spareName){
        try {
            clickOnElement(webDriver.findElement(By.xpath(".//*[@id='device_list']/tbody/tr/td[contains(text(),'" + spareName + "')]")));
            logger.info("Clicked on created spare");
            }catch (Exception e){
            logger.error("Cannot click on created spare");
            Assert.fail("Cannot click on created spare");
        }

        }


    public void deleteCreatedSpareElement(){
        clickOnElement(deleteSpareButton);
        logger.info("element was deleted from sparePage");
    }

    public void checkSpareWasCreated(String spareName){
        if(createdSparePresent(spareName)){
            logger.info("spare was present");
        }else{
            logger.error("Spare wasn't created");
            Assert.fail("Spare wasn't created");
        }
    }

    public void isAllCreatedElementsDeleted(String spareName){

        if(createdSparePresent(spareName)){
            logger.error("Not all elements was deleted");
            Assert.fail("Not all elements was deleted");
        }else{
            logger.info("All created elements was deleted successful");
        }
    }
}
