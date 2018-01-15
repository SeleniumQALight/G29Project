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
        logger = Logger.getLogger("ActionsWithOurElement");   // створює лог файл з іменем цього класу;
    }

    /**
     * Method enter text in to input
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
     * Method click on WebElement
     *
     * @param element
     */
    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            //     logger.info(element + " was clicked" + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method verify that WebElement is displayed and is enabled
     *
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Is element Present? - " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Is element Present? - false");
            return false;
        }
    }


    /** Method for to set element of Checkbox ("Checked" or "Unchecked")
     *
     * @param element
     * @param neededState
     */
    public static void setStateToCheckBox(WebElement element, String neededState) {
        try {
            if (neededState.equals("Checked")) {
                if (element.isSelected() == false) {
                    clickOnElement(element);
                    logger.info("CheckBox status was changed to 'Checked' status");
                } else {
                    logger.info("CheckBox status is already 'Checked'");
                }
            } else if (neededState.equals("Unchecked")) {
                if (element.isSelected() == true) {
                    clickOnElement(element);
                    logger.info("CheckBox status was changed to 'Unchecked' status");
                } else {
                    logger.info("CheckBox status is already 'Unchecked'");
                }
            }
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**Method for to select option in Drop Down
     *
     * Method select
     * @param element
     * @param option
     */
    public void selectOptionsInDropDown(WebElement element, WebElement option){
        try {
            clickOnElement(element);
            clickOnElement(option);
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }



    private static void logErrorAndStopTest() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }



}
