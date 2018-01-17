package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import static libs.ActionsWithOurElements.*;

public class ParentPage {
    protected Logger logger;
    String expectedURL;
    WebDriver webDriver;

    public ParentPage(WebDriver webDriver, String expectedURL) {
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
        //ActionsWithOurElements actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedURL = "http://v3.test.itpmgroup.com" + expectedURL;
    }

    public void checkCurrentUlr(){
        try{
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedURL);
        }catch (Exception e){
            logger.error("Cannot get url");
            Assert.fail("Cannot get url");
        }
    }
}
