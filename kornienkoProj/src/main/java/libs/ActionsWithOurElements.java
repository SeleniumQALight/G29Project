package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver driver;
    Logger logger;


    public ActionsWithOurElements(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info("Input: " + text);
        } catch (Exception ex) {
            logErrorAndStopTest(input);
        }
    }

    public void clickOnElements(WebElement element) {
        try {

            element.click();
            logger.info("Element was clicked" + element.getTagName());
        } catch (Exception ex) {
            logErrorAndStopTest(element);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed()&&element.isEnabled();
        } catch (Exception ex) {

        }
    }

    private void logErrorAndStopTest(WebElement element) {
        logger.error("Can't work with element " + element);
    }
 }
