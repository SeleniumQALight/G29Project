package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    static Logger logger;
    static WebDriverWait webDriverWait20;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait20 = new WebDriverWait(webDriver, 3);
    }

    /**
     * Method Enter text in to input and textArea
     *
     * @param input
     * @param text
     */

    public static void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was entered in to input" + input);
        } catch (Exception e) {
            logErrorAndStopTest(input);
        }
    }

    /**
     * Method click on element
     *
     * @param element
     */
    public static void clickOnElement(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest(element);
        }
    }

    /**
     * Method return status of webElement, true or false
     *
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Is element present? - " + tempState + " " + element);
            return tempState;
        } catch (Exception e) {
            logger.info("Is element present? - false");
            return false;
        }
    }

    /**
     * Method select needed line in DropDown by WebElement
     *
     * @param select
     * @param option
     */
    public void selectOptionsInDropDown(WebElement select, WebElement option) {
        clickOnElement(select);
        clickOnElement(option);
    }

    /**
     * Method select line in DropDown by xPathLocator
     *
     * @param select
     * @param xPathLocator
     */
    public void selectOptionsInDropDown(WebElement select, String xPathLocator) {
        try {
            selectOptionsInDropDown(select, webDriver.findElement(By.xpath(xPathLocator)));
        } catch (Exception e) {
            logErrorAndStopTest(select);
        }
    }

    /**
     * Method set needed state in CheckBox
     *
     * @param element
     * @param neededState (Can be only 'Checked' or 'Unchecked')
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
                logErrorAndStopTest(element);
            }
        }
    }

    private static void logErrorAndStopTest(WebElement element) {
        logger.error("Can't work with element " + element);
        Assert.fail("Can't work with element " + element);
    }
}