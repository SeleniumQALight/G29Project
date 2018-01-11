package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class actionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public actionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    //SENDKEYS METHOD
    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was succesfully inputed " + input);
             }
        catch (Exception e) {
            logErrorAndStopTest(input);
        }
    }

    //CLICK METHOD
    public void clickOnElement (WebElement button) {
        try {
            button.click();
            logger.info("Element was clicked on" + button);
        }
        catch (Exception e) {
            logErrorAndStopTest(button);
        }
    }

    //FIND AND CHECK METHOD

    public boolean isElementPresent (WebElement element) {
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled(); //&& => if right false - dont check left side
            logger.info("Is Element Present? - " + tempState);
            return tempState;
        }
        catch ( Exception e) {
            logger.info("Is Element Present? - False " );
            return false;
        }
    }

    private void logErrorAndStopTest (WebElement elemnt){
        logger.error("Cannot work with Element " + elemnt); // log and concole
        Assert.fail("Cannot work with Element " + elemnt); // get in the report
    }
}
