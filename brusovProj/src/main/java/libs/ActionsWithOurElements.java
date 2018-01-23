package libs;

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

    public ActionsWithOurElements(WebDriver webDriver) { // Constructor
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver,20);
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
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
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
//    public static void makeCheckboxSelected (WebElement element){
//        if(!element.isSelected()){
//            element.click();
//        }
//    }

    /**
     * Method make checkbox unselected
     * @param element
     */
//    public static void makeCheckboxUnSelected (WebElement element){
//        if(element.isSelected()){
//            element.click();
//        }
//    }

    /**
     * Method make checkbox selected or unselected from dependency of selectionState
     * @param checkBox
     */
//    public static void setStateToCheckBox (WebElement checkBox, boolean selectionState){
//        if(selectionState){
//            makeCheckboxSelected(checkBox);
//        }else {
//            makeCheckboxUnSelected(checkBox);
//        }
//    }

    //Correct from Taras
    /**
     * Method set needed state in CheckBox
     * @param element
     * @param neededState (Can be only 'Checked' or 'Unchecked')
     */
    public void setStateToCheckBox(WebElement element, String neededState){
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

    //My
//    /**
//     * Method open dropdown and some option
//     * @param element, option
//     */
//    public static void selectOptionsInDropDown (WebElement element, WebElement option){
//        element.click();
//        option.click();
//    }

    //Correct from Taras
//    /**
//     * Method select needed line in DropDown by WebElement
//     * @param select
//     * @param option
//     */
//    public void selectOptionsInDropDown(WebElement select, WebElement option){
//        clickOnElement(select);
//        clickOnElement(option);
//    }

    public static void selectOptionsInDropDown(WebElement selectDropDown, String textInDropDown){
        try {
            Select options = new Select(selectDropDown);
            options.selectByVisibleText(textInDropDown); // Can do it with ByValue
            logger.info(textInDropDown + " was selected in DD");
        }catch (Exception e){
            logErrorAndStopTest();
        }
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
