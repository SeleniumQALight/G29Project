package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ActionsWithOurElement {
    WebDriver webDriver;
    static Logger logger;
    static   WebDriverWait webDriverWait20;  // вебдрайвер - почекай 20c. - любу команду він буде виконувати кожні 0,5 сек. протягом 20с.

    public ActionsWithOurElement(WebDriver webDriver) {       // конструктор
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElement");   // створює лог файл з іменем цього класу;
        webDriverWait20 = new WebDriverWait(webDriver,20);    // вебдрайвер - почекай 20c.
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
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));    // почекай до 20 с. доки елемен стане клікабельний;
            ExpectedConditions.not(ExpectedConditions.invisibilityOf(element));         // почекай поки елемент стане видимим
            element.click();
            logger.info(element + " was clicked" + element);
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

    /**Method for to select option in Drop Down
     *
     * Method select
     * @param select
     * @param option
     */
    public static void selectOptionsInDropDown(WebElement select, WebElement option){
            clickOnElement(select);
            clickOnElement(option);
           }

    public static void selectOptionsInDropDown(WebElement selectDropDown,String textInDropDown){   // вибере елемент програмно
        try {
            Select options =new Select(selectDropDown);    // відкрили селект і отримали всю вибірку з селекту
            options.selectByVisibleText(textInDropDown);   // шукає едемент по тексту, що ми бачим
     //     options.selectByValue(textInDropDown);         // шукає едемент по Value, що ми бачим
            logger.info(textInDropDown + " was selectedd in DropDown");
        }catch (Exception e){
            logErrorAndStopTest();
        }
    }

    private static void logErrorAndStopTest() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }



}
