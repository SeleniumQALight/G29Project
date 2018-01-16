package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ActionsWithOurElements {
    WebDriver webDriver;
    static Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
    }

    /**
     * Mathod Enter text in to input and textArea
     * @param input
     * @param text
     */
    public static void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input" + input);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static boolean isElementPresent(WebElement element){
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is Element Present? -  " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is Element Present? - false");
            return false;
        }
    }


    private static void logErrorAndStopTest() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }
}
