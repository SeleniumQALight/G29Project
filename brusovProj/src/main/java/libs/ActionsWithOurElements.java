package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webdriver;
    static Logger logger;

    public ActionsWithOurElements(WebDriver webdriver) {
        this.webdriver = webdriver;
        logger = Logger.getLogger("ActionsWithOurElements");
    }

    /**
     * Method Enter text in to input and textArea
     * @param input
     * @param text
     */
    public static void enterTextInToInput(WebElement input,String text){
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + "was inputed in to input " + input);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    /**
     * Method Click on elements on page
     * @param element
     */
    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Elemet was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method Find elements on page for present them
     * @param element
     * @return
     */
    public static boolean isElemetPresent(WebElement element){
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

    /**
     * Method make checkbox selected
     * @param element
     */
    public static void makeCheckboxSelected (WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }

    /**
     * Method make checkbox unselected
     * @param element
     */
    public static void makeCheckboxUnSelected (WebElement element){
        if(element.isSelected()){
            element.click();
        }
    }

    /**
     * Method make checkbox selected or unselected from dependency of selectionState
     * @param checkBox
     */
    public static void setStateToCheckBox (WebElement checkBox, boolean selectionState){
        if(selectionState){
            makeCheckboxSelected(checkBox);
        }else {
            makeCheckboxUnSelected(checkBox);
        }
    }

    /**
     * Method open dropdown and some option
     * @param element, option
     */
    public static void selectOptionsInDropDown (WebElement element, WebElement option){
        element.click();
        option.click();
    }

    /**
     * Method Stop test if some element was not found
     * @param
     */
    private static void logErrorAndStopTest(){
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }
}
