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
        logger = Logger.getLogger("ActionsWithOurElement");
    }

    /**
     * Method Enter text in to input and textArea
     * @param input
     * @param text
     */

    public static void enterTextToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was pasted in to input " +input );
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }
    public static boolean isElementPresent(WebElement element){
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is Element present? -  " + tempState );
            return tempState;
        }catch (Exception e){
            logger.info("Is Element present? - false  " );
            return false;
        }
    }

    public static void clickOnElement(WebElement element){
        try{
            element.click();
            logger.info("Element was clicked " );
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    private static void logErrorAndStopTest(){
        logger.error("Cant work with element " ); //пишет в лог
        Assert.fail("Cant work with element " ); // пишет в консоль
    }
}
