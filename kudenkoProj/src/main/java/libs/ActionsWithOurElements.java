package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {

   WebDriver webDriver;
   static WebDriverWait webDriverWait20;

    static Logger logger =  Logger.getLogger("ActionsWithOurElements");

    public ActionsWithOurElements(WebDriver webDriver) {
       this.webDriver = webDriver;
       webDriverWait20 = new WebDriverWait(webDriver, 20);
       // logger = Logger.getLogger("ActionsWithOurElements");
    }

    /**
     * Method puts text into input or textareas
     * @param input
     * @param text
     */
    public static void enterTextInToInput(WebElement input, String text){
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed into input " + input);
        }catch(Exception e){
            logErrorStopAndStopTest();
        }
    }

    /**
     * Method clicks on the element
     * @param element
     */
    public static void clickOnElement(WebElement element){
        try{
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(element));
            //webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.invisibilityOf(element)));
            element.click();
            logger.info(element + " was clcicked");
        }catch (Exception e){
            logErrorStopAndStopTest();
        }
    }

    /**
     * Method clickes ENTER key on keyboard
     * @param element
     */
    public static void clickEnter(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    /**
     * Method clicks ENTER without element.
     */
    public static void clickEnterKey (WebDriver webDriver){
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ENTER);
        action.perform();
    }

    /**
     * Method checks present and enable of element
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element){
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled();
            logger.info("Is element present? - " + tempState);
            return tempState;
        }catch (Exception e){
            logger.info("Is element present? - false");
            return false;
        }
    }

    /**
     * sets checkbox in selected state
     * @param element
     * @param neededState can be "checked" and "unchecked";
     */
    public static void setStateToCheckBox(WebElement element, String neededState){

        final String CHECK_STATUS = "checked";
        final String UNCHECKED_STATUS = "unchecked";

        if(!CHECK_STATUS.equals(neededState) && !UNCHECKED_STATUS.equals(neededState)){
            logger.error("You entered wrong string to checkbox");
            Assert.fail("You entered wrong string to checkbox");
        }

        isElementPresent(element);

        try{

            if(neededState.equals(CHECK_STATUS)){
                if(!element.isSelected()){
                    element.click();
                }
            }

            if(neededState.equals(UNCHECKED_STATUS)){
                if(element.isSelected()){
                    element.click();
                }
            }

            logger.info("placed checkbox " + element + " into state " + neededState);

        }catch (Exception e){
            logErrorStopAndStopTest();
        }
    }

    /**
     * Method selects option by visible text
     * @param element
     * @param option is a name of select option (not value!)
     */
    public static void selectOptionsInDropDown(WebElement element, String option){
        try{
            Select select = new Select(element);
            //wait.until(ExpectedConditions.textToBePresentInElement(element, option));
            select.selectByVisibleText(option);
            logger.info("Selected element " + element + " with option " + option);
        }catch (Exception e){
                logErrorStopAndStopTest();
        }
    }



    /**
     * Method calls error when element didn't found
     */
    private static void logErrorStopAndStopTest(){
        logger.error("Cannot work with element ");
        Assert.fail("Cannot work with element ");
    }

}

// ДЗ  :
//         1.   Написать метод по работе с чекбоксами
// neededState can be only Checked or Unchecked
//         setStateToCheckBox(WebElement element, String neededState)
//         2.  selectOptionsInDropDown(WebElement element, WebElement option)
//         3.  В LoginPage реализовать метод, который бы с помощью вызова уже реализованых выпослнял следующее: открывал логин Пейдж, вводил логин, вводил пароль и сликал кнопку
//public void loginUser(String login, String pass)
//        4.  Написать тест по проверке функционала логина с невалидными данными (используя степ с пункта 3)(использовать один набор данных , например notValidLogin  и notValidPass)
