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
     * Method enter text into Input text area
     *
     * @param input
     * @param text
     */
    public static void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was succesfully inputed " + input);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    //CLICK METHOD
    public static void clickOnElement(WebElement button) {
        try {
            button.click();
            logger.info("Element was clicked on" + button);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    //FIND AND CHECK METHOD

    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled(); //&& => if right false - dont check left side
            logger.info("Is Element Present? - " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Is Element Present? - False ");
            return false;
        }
    }

    /**
     * Method for set correct state to the Checkboxx
     * @param element
     * @param neededState
     */
    public static void setStateToCheckBox(WebElement element, String neededState) {
        try {
            if (neededState.equals("Checked")) {
                if (element.isSelected() == false) {
                    element.click();
                    logger.info("CheckBox was clicked by system");
                } else {
                    logger.info("CheckBox was previously selected");
                }

            } else if (neededState.equals("Unchecked")) {
                if (element.isSelected() == true) {
                    element.click();
                    logger.info("CheckBox was unchecked by system");
                } else {
                    logger.info("CheckBox was previously unchecked");
                }
            }

        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method for selection option in the Drop Down list
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        try {
            clickOnElement(element);
            clickOnElement(option);
        }
        catch (Exception e) {
            logErrorAndStopTest();
        }
    }


    private static void logErrorAndStopTest() {
        logger.error("Cannot work with Element "); // log and concole
        Assert.fail("Cannot work with Element "); // get in the report
    }
}
