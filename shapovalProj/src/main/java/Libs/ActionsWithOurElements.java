package Libs;



import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    static Logger logger;
    static WebDriverWait webDriverWait20;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver,20);
    }


    /**
     * Method Enter text into input textArea
     * @param input
     * @param text
     */
    public static void enterTextIntoInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed into input " + input);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    public void selectOptionsInDropDown(WebElement selectDropDown,String textInDropDown){
        try{
            Select options = new Select(selectDropDown);
//            options.selectByVisibleText(textInDropDown);
            options.selectByValue(textInDropDown);
            logger.info(textInDropDown + " was selected in DD ");
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }


    public static void clickOnElement(WebElement element){
        try{webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            logger.info("Element was clicked" + element);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    public static boolean isElementPresent(WebElement element){
        try{
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info(" Is element present?  - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info(" Is element Present? - false");
            return false;
        }
    }

    private static void logErrorAndStopTest(){
        logger.error(" Can not work with element ");
        Assert.fail(" Can not work with element ");
    }
}

