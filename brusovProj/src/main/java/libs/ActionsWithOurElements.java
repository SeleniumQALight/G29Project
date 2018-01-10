package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webdriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webdriver) {
        this.webdriver = webdriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextInToInput(WebElement input,String text){
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + "was inputed in to input " + input);
        }catch (Exception e){
            logErrorAndStopTest(input);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Elemet was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest(element);
        }
    }

    public boolean isElemetPresent(WebElement element){
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled(); //&& - "и" - и отображается и активен (одно & - Если первый фолс,
                                                                            // то второй не проверяется, а возвращает фолс.
            logger.info("Is Element Present ? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is Element Present ? - false");
            return false;
        }
    }

    private void logErrorAndStopTest(WebElement element){
        logger.error("Can not work with element " + element);
        Assert.fail("Can not work with element"+ element);
    }
}