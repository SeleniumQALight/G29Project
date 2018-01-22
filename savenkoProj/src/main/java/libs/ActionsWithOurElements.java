package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.apache.commons.lang3.RandomStringUtils.*;



public class ActionsWithOurElements {
    WebDriver webDriver;
    static Logger logger;
    static WebDriverWait webDriverWait20;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver, 20); //wait for 20 seconds
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
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(button));
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(button)));
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
     * Method for the check CheckBox state and select/unselect it
     *
     * @param element
     * @param neededState
     */
    public void setStateToCheckBox(WebElement element, String neededState) {

        final String CHECK_STATUS = "Checked";
        final String UNCHECK_STATUS = "Unchecked";

        if (!neededState.equals(CHECK_STATUS) && !neededState.equals(UNCHECK_STATUS)) {
            logger.error(neededState + " - Value of neededState is not expected ");
            Assert.fail(neededState + " - Value of neededState is not expected ");
        } else {
            try {
                if (neededState.equals(CHECK_STATUS) && !element.isSelected() ||
                        neededState.equals(UNCHECK_STATUS) && element.isSelected()) {
                    clickOnElement(element);
                } else {
                    logger.info("CheckBox has " + neededState + " state already ");
                }
            } catch (Exception e) {
                logErrorAndStopTest();
            }
        }
    }


//    public static void setStateToCheckBox(WebElement element, String neededState) {
//        try {
//            if (neededState.equals("Checked")) {
//                if (element.isSelected() == false) {
//                    element.click();
//                    logger.info("CheckBox was clicked by system");
//                } else {
//                    logger.info("CheckBox was previously selected");
//                }
//
//            } else if (neededState.equals("Unchecked")) {
//                if (element.isSelected() == true) {
//                    element.click();
//                    logger.info("CheckBox was unchecked by system");
//                } else {
//                    logger.info("CheckBox was previously unchecked");
//                }
//            }
//        } catch (Exception e) {
//            logErrorAndStopTest();
//        }
//    }

    /**
     * Method for selection option in the Drop Down list
     *
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        try {
            clickOnElement(element);
            clickOnElement(option);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public void selectOptionInDropDown(WebElement selectDropDown, String textInDropdown) {
        try {
            Select options = new Select(selectDropDown);  //select element - list
            options.selectByVisibleText(textInDropdown);
            //options.selectByValue(Value);
            logger.info(textInDropdown + " was selected in DropDown");
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    private static void logErrorAndStopTest() {
        logger.error("Cannot work with Element "); // log and concole
        Assert.fail("Cannot work with Element "); // get in the report
    }

    public static String generateRandomNumeric(int length) {
        try {
            String tempRandom = randomNumeric(length);
            return tempRandom;
        }
        catch (Exception e) {
            logErrorAndStopTest();
            logger.info("Cannot generate random");
            return "Cannot generate random";
        }
    }


}
