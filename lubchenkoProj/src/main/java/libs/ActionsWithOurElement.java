package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElement {
    WebDriver webDriver;
    static Logger logger;

    public ActionsWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
    }

    /**
     * Method enter text in to input and textArea
     *
     * @param input
     * @param text
     */

    public static void enterTextInToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + input);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    /**
     * Method click on button and other clicked element
     *
     * @param element
     */

    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void setStateToCheckBox(WebElement element, String neededState) {
        if (element.isSelected() == true) {
        } else {
            return false;
        }
    }

    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        try {
            element.isSelected();
        } catch (Exception e) {
            logErrorAndStopTest(element);
        }
    }

    /**
     * Method check if element is present
     *
     * @param element
     */

    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Is Element Present ? - " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Is Element Present ? -false");
            return false;
        }
    }

    /**
     * Method find log errors and stop test
     *
     * @param
     */

    private static void logErrorAndStopTest() {
        logger.error("Can not work with element " );
        Assert.fail("Can not work with element " );
    }
}
