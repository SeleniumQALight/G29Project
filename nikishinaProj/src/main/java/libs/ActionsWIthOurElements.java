package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWIthOurElements {
    WebDriver webDriver;
    static Logger logger;

    public ActionsWIthOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements"); //эта строка нужна для того, чтобы создать объект - то есть создать файл с именем этого класса
    }

    //создаем метод, который будет вводить текст в инпуты, а еще в textarea:

    /**
     * Method Enter text into input and textArea
     * @param input
     * @param text
     */
    public static void enterTextInToInput (WebElement input, String text) {  //- куда - инпут (тип - вебэлемент), что - текст (тип - стринга)
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + input);
        }catch (Exception e) {
            logErrorAndStopTest ();
        }
    }

    //создадим метод по работе с кнопками:

    /**
     *  Method click on the Elements: button, link, radiobutton, checkbox etc.
     * @param element
     */
    public static void clickOnElement (WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    //пишем метод, который будет проверять наличчие элемента на странице. он уже будет не войд, потому что будет возвращать состояние тру/фолс:
    /**
     * Method to check whether any element is present in DOM, present on the page and enabled or disabled
     * @param element
     * @return
     */
    public static boolean isElementPresent (WebElement element) {
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled(); //спрашиваем у аватара: ты есть - да, ты доступен - нет. значит
            //темпстейт - фолс, возвращаем - фолс. если этого элемента вообще нет, тогда вывалится эксепшен и мы попадем в блок кэтч
            logger.info ("Is Element Present? - " + tempState);
            return tempState; //&& - двойное логическое "и" (оба условия должны выполнятся, при этом если
            //левая часть фолс, то правую можно не проверять, потому что  результат в любом случае уже фолс
            //здесь толкование: верни, что элемент есть и он активный
        }catch (Exception e) {
            logger.info ("Is Element Present? - false");
            return false;
        }
    }

//    1.   Написать метод по работе с чекбоксами
//    neededState can be only Checked or Unchecked
//    setStateToCheckBox(WebElement element, String neededState)
    /**
     * Method to set checkbox in needed state
     * @param element
     * @param neededState
     */
    public static void setStateToCheckBox (WebElement element, String neededState) {
        isElementPresent(element);
        try{
            if ((!element.isSelected() && neededState.equals("Checked")) || (element.isSelected() && neededState.equals("Unchecked"))) {
                clickOnElement(element);
            } else {
                logger.info ("Element is already in needed state");
            }
        }catch (Exception e) {
            logErrorAndStopTest();
        }
    }

//    2.  selectOptionsInDropDown(WebElement element, WebElement option)
    /**
     * Method to open dropdown and select one option from it
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown (WebElement element, WebElement option) {
        Assert.assertTrue("Dropdown is not present", isElementPresent(element));
        clickOnElement(element);
        Assert.assertTrue("Dropdown option is not present", isElementPresent(option));
        clickOnElement(option);
        }

    //делаем метод для обработки эксепшена, который потом будем вызывать в методе трай/кетч для ввода текста в инпут или метод клика по элементам (выше описаны):
    // в него передаем сам элемент (WebElement element), чтобы потом понять, с каким элементом не можем работать logger.error("Can not work with element " + element )
    /**
     * Method informs on exception of working with elements and records to log
     */
    private static void logErrorAndStopTest () {
        logger.error("Can not work with element "); // пишет в консоль и в лог
        Assert.fail ("Can not work with element "); //пишет в отчет и останавливает тест
    }

}