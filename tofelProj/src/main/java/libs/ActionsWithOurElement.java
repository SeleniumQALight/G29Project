package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElement {
    WebDriver webDriver;
    static Logger logger;


    public void setStateToCheckBox(WebElement checkBox, String neededState) {
        if (checkBox.isSelected()) {
            if (neededState.equals("Check")) {
                logger.info("Checkbox is checked" + checkBox);
            } else {
                clickOnElement(checkBox);
            }
        } else {
            if (neededState.equals("UnCheck")) {
                logger.info("Checkbox is Unchecked" + checkBox);
            } else {
                clickOnElement(checkBox);

            }
        }
    }

/*public void  selectOptionsInDropDown(WebElement dropDown, WebElement dropDownDictionary){
isChecked=true;
if( dropDown){
}else {
}
}*/


    public ActionsWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
    }

    public static void enterTextInToInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + input);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked " + element);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

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

    private static void logErrorAndStopTest() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }
}