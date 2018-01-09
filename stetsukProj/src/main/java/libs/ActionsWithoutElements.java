package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithoutElements {
    WebDriver webDriver;
    Logger logger;

    /**
     * Constructor declaration
     * @param webDriver
     */

    public ActionsWithoutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method enter text in to any input field
     * @param input
     * @param text
     */
    public void enterTextInToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys();
            logger.info(text + " was inputed in to input " + input);
        }catch (Exception e){
            logErrorAndStopTest(input);
        }
    }

    /**
     * Method click on element and print log info
     * @param element
     */
    public void clickOnElement(WebElement element){
        try {
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e){
            logErrorAndStopTest(element);
        }
    }

    /**
     * Boolean method check element to Displayed and Enabled and print log info
     * @param element
     * @return
     */
    public boolean isElementPresent(WebElement element){
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is element present ? " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is element present ? - false");
            return false;
        }
    }

    /**
     * Method breake test and print log with element
     * @param element
     */
    private void logErrorAndStopTest(WebElement element){
        logger.error("Can not work with elements " + element);
        Assert.fail("Can not work with elements " + element);
    }
}
