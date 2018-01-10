package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {

    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextInToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed into input " + input);
        }catch(Exception e){

            logErrorStopAndStopTest(input);
        }
    }

    public void clickOnElement(WebElement element){
        try{
            element.click();
            logger.info(element + " was clcicked");
        }catch (Exception e){
            logErrorStopAndStopTest(element);
        }
    }

    public boolean isElementPresent(WebElement element){
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is element present? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is element present? - false");
            return false;
        }
    }

    private void logErrorStopAndStopTest(WebElement element){
        logger.error("Cannot work with element " + element);
        Assert.fail("Cannot work with element " + element);
    }
}
