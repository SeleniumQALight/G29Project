package libs;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsWithoutElements {
    WebDriver webDriver;
    static Logger logger;
    static WebDriverWait webDriverWait20;

    /**
     * Constructor declaration
     *
     * @param webDriver
     */
    public ActionsWithoutElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithoutElements");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    /**
     * Method enter text in to any input field
     *
     * @param input
     * @param text
     */
    @Step
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
    @Step
    public static void clickOnElement(WebElement element) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
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

    /**
     * change checkbox status that need
     *
     * @param element
     * @param neededState
     */
    public static void setStateToCheckBox(WebElement element, String neededState) {
        final String CHECK_STATUS = "check";
        final String UNCHECK_STATUS = "uncheck";
        if (!neededState.equals(CHECK_STATUS) && !neededState.equals(CHECK_STATUS)) {
            logger.error(neededState + " - Value of neededState is not expected ");
            Assert.fail(neededState + " - Value of neededState is not expected ");
        } else {
            try {
                if ((element.isSelected() != true && neededState == CHECK_STATUS) || (element.isSelected() == true && neededState == UNCHECK_STATUS)) {
                    clickOnElement(element);
                } else {
//                (element.isSelected()==true && neededState == "check") || (element.isSelected()!==true && neededState == "uncheck")
                    logger.info("CheckBox have needed state");
                }
            } catch (Exception e) {
                logErrorAndStopTest();
            }
        }
    }

    /**
     * open dropdown and whose needed
     *
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        clickOnElement(element);
        clickOnElement(option);
    }


    public static void selectOptionsInDropDown(WebElement selectDropDown, String textInDropDown) {
        try {
            Select options = new Select(selectDropDown);
            options.selectByVisibleText(textInDropDown);
            logger.info(textInDropDown + " was selected in DD");
        }catch (Exception e){
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
