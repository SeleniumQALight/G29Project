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

    public void enterTextIntoInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input" + input);
        }catch (Exception e){
            logErrorAndStopTest(input);
        }
    }

    public void clickOnElement(WebElement element){
        try{
            element.click();;
            logger.info("Element clicked " + element);
        }catch (Exception e){
            logErrorAndStopTest(element);
        }
    }

    public boolean isElementPresent(WebElement element){
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is element present ? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is element present ? - false");
            return false;
        }
    }

    private void logErrorAndStopTest(WebElement element){
        logger.error("Can not work with element" + element);
        Assert.fail("Can not work with element");
    }
}
