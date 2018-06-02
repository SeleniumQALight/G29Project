package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElement {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input" + input);
        }catch (Exception e) {

        }
    }

    public void clickOnElement(WebElement element){
        try {
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e){
            logerrorAndStopTest(element);
        }
    }

    public boolean isElementPresent(WebElement element){
        try {
            boolean tempState =  element.isDisplayed()&&element.isEnabled();
            logger.info("Is Element Present ? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is Element Present ? - " + false);
            return false;
        }
    }

    private void logerrorAndStopTest(WebElement element){
        logger.error("Can not work with elemnt " + element);
        Assert.fail("Can not work with elemnt " + element);
    }
}
