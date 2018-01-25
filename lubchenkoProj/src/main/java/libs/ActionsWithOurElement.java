package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElement {
    WebDriver webDriver;
    static Logger logger;
    static WebDriverWait webDriverWait20;

    public ActionsWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    /**
     * Method enter text in to input and textArea
     *
     * @param input
     * @param text
     */

    public static void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + input);
        } catch (Exception e) {
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
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void setStateToCheckBox(WebElement element, String neededState) {
        if (element.isSelected() == true) {
            if (neededState.equals("Checked")) {
                logger.info(element + " Element in checked state ");
            } else {
                clickOnElement(element);
            }
        } else {
            if (neededState.equals("Checked")) {
                clickOnElement(element);
            } else {
                logger.info(element + " Element in checked state ");
            }
        }
    }

    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        clickOnElement(element);
        clickOnElement(option);
    }

    public void selectOptionsInDropDown (WebElement selectDropDown, String textInDropDown) {
         try {
             Select options = new Select (selectDropDown);
            // options.selectByVisibleText(textInDropDown);
             logger.info(textInDropDown + " was selected in DD");
         } catch (Exception e){
             logErrorAndStopTest();
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
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }
}
