package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWIthOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWIthOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass()); //эта строка нужна для того, чтобы создать объект - то есть создать файл с именем этого класса
    }

    //создаем метод, который будет вводить текст в инпуты, а еще в textarea:
    public void enterTextInToInput (WebElement input, String text) {  //- куда - инпут (тип - вебэлемент), что - текст (тип - стринга)
        try{
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputed in to input " + input);
        }catch (Exception e) {
            logErrorAndStopTest (input);
        }
    }

    //создадим метод по работе с кнопками:
    public void clickOnElement (WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked " + element);
        }catch (Exception e) {
            logErrorAndStopTest(element);
        }
    }

    //пишем метод, который будет проверять наличчие элемента на странице. он уже будет не войд, потому что будет возвращать состояние тру/фолс:
    public boolean isElementPresent (WebElement element) {
        try{
            boolean tempState = element.isDisplayed()&&element.isEnabled(); //спрашиваем у аватара: ты есть - да, ты доступен - нет. значит
            //темпстейт - фолс, возвращаем - фолс. если этого элемента вообще нет, тогда вывалится эксепшен
            logger.info ("Is Element Present? - " + tempState);
            return tempState; //&& - двойное логическое "и" (оба условия должны выполнятся, при этом если
            //левая часть фолс, то правую можно не проверять, потому что  результат в любом случае уже фолс
            //здесь толкование: верни, что элемент есть и он активный
        }catch (Exception e) {
            logger.info ("Is Element Present? - false");
            return false;
        }
    }

    //делаем метод для обработки эксепшена, который потом будем вызывать в методе трай/кетч для ввода текста в инпут или метод клика
    // по элементам (выше описан):
    // в него передаем сам элемент (WebElement element), чтобы потом понять, с каким лементом не можем работать logger.error("Can not work with element " + element )
    private void logErrorAndStopTest (WebElement element) {
        logger.error("Can not work with element " + element ); // пишет в консоль и в лог
        Assert.fail ("Can not work with element " + element ); //пишет в отчет и останавливает тест
    }

}

