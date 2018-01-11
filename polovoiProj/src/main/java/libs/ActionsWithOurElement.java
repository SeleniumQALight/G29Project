package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElement {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger=Logger.getLogger(getClass());
    }

    public void enterTextToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was pasted in to input " + input);
        }catch (Exception e){
            logErrorAndStopTest(input);
        }
    }
    public boolean isElementPresent(WebElement element){
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is Element present? -  " + tempState );
            return tempState;
        }catch (Exception e){
            logger.info("Is Element present? - false  " );
            return false;
        }
    }

    public void clickOnElement(WebElement element){
        try{
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e){
            logErrorAndStopTest(element);
        }
    }

    private void logErrorAndStopTest(WebElement element){
        logger.error("Cant work with element " + element); //пишет в лог
        Assert.fail("Cant work with element " + element); // пишет в консоль
    }
}
