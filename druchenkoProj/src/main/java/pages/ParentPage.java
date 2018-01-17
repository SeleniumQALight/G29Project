package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWithOurElements.*;

public class ParentPage {
    WebDriver webDriver;

    protected Logger logger;
    String expectedUrl;
    public ParentPage(WebDriver webDriver,String expectedUrl){  //конструктор не возвращает значения и называется как класс (создается с помощью Alt + insert)
        ActionsWithOurElements actionsWithOurElements;
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedUrl = "http://v3.test.itpmgroup.com" +expectedUrl;
    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedUrl);
        }catch (Exception e){
            logger.error("Can not get url");
            Assert.fail("Can not get url");
        }
    }
}
