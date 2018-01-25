package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWithOurElements.*;



public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    protected Logger logger; // protected нужно чтобы был доступен
    String expectedUrl;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
       logger =  Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements=new ActionsWithOurElements(webDriver);
//        this.expectedUrl="http://v3.test.itpmgroup.com"+ expectedUrl;
        this.expectedUrl=configProperties.base_url()+ expectedUrl;
    }
//    создаем что ожидаемая страница будет иметь ожидаемый результат
    public void checkCurrentUrl (){
//        try {
//            Assert.assertEquals("Url is not expected",webDriver.getCurrentUrl(),expectedUrl);
//        }catch (Exception e ){
            logger.error("Can not get url");
            Assert.fail("Can not get url");

        }
    }

