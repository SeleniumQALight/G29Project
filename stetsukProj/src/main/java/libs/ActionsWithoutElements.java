package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithoutElements {
    WebDriver webDriver;
    static Logger logger;

    /**
     * Constructor declaration
     *
     * @param webDriver
     */
    public ActionsWithoutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithoutElements");
    }

    /**
     * Method enter text in to any input field
     *
     * @param input
     * @param text
     */
    public static void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input ");
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method click on element and print log info
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

    /**
     * Boolean method check element to Displayed and Enabled and print log info
     *
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Is element present ? " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Is element present ? - false");
            return false;
        }
    }

    public static void setStateToCheckBox(WebElement element, String neededState) {
        try {
            if ((element.isSelected() != true || neededState == "check") && (element.isSelected() == true || neededState == "uncheck")) {
                clickOnElement(element);
            } else {
//                (element.isSelected()==true && neededState == "check") || (element.isSelected()!==true && neededState == "uncheck")
                logger.info("CheckBox have needed state");
            }
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method breake test and print log with element
     */
    private static void logErrorAndStopTest() {
        logger.error("Can not work with elements ");
        Assert.fail("Can not work with elements ");
    }
}
