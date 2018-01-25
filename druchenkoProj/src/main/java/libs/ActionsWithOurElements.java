package libs;

import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import org.junit.Assert;
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
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    /**
     * Method Enter Text in to input and textArea
     * @param input
     * @param text
     */

    public static void enterTextIntoInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input" + input);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    /**
     * Method Click on Links, Image and others
     * @param element
     */

    public static void clickOnElement(WebElement element){
        try{
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info("Element clicked " + element);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    /**
     * Method Find Present Element
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element){
        try {
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is element present ? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is element present ? - false");
            return false;
        }
    }

    /**
     * Method Writes log and Stops test
     * @param
     */

    private static void logErrorAndStopTest(){
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public static void setStateToCheckBox(WebElement element, String neededState){
        final String CHECK_STATUS = "Checked";
        final String UNCHECK_STATUS = "Unchecked";
        if (!neededState.equals(CHECK_STATUS) && !neededState.equals(UNCHECK_STATUS)){
            logger.error(neededState + " - Value of neededState is not expected ");
            Assert.fail(neededState + " - Value of neededState is not expected ");
        }else {
            try {
                if (neededState.equals(CHECK_STATUS) && !element.isSelected() ||
                        neededState.equals(UNCHECK_STATUS) && element.isSelected()){
                    clickOnElement(element);
                } else {
                    logger.info("CheckBox has " + neededState + " state already ");
                }
            }catch (Exception e){
                logErrorAndStopTest();
            }
        }
    }

//    public static void selectOptionsInDropDown(WebElement select, WebElement option){
//        clickOnElement(select);
//        clickOnElement(option);
//
//    }

    public static void selectOptionsInDropDown(WebElement selectDropDown, String textInDropdown){
        try {
            Select options = new Select(selectDropDown);
            options.selectByVisibleText(textInDropdown);
            logger.info(textInDropdown + " was selected in DD");
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

}
