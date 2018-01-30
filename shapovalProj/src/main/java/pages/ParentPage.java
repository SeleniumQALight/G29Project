package pages;

import Libs.ActionsWithOurElements;
import Libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Libs.ActionsWithOurElements.*;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;

   protected Logger logger;                 // vubrat' loger apa4 log 4 j!!!!
   String expectedURL;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);


    public ParentPage(WebDriver webDriver, String expectedURL) {// konstryktor nastoiki
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedURL = configProperties.base_url() + expectedURL;
    }

    public void checkCurentUrl(){
        try{
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(),expectedURL);

        }catch (Exception e){
            logger.error("Can not get URL");
            Assert.fail("Can not get URL");
        }
    }

}
