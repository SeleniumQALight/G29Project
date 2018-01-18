package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    protected Logger logger;
    String expectedUrl;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        //this.expectedUrl = "http://v3.test.itpmgroup.com" + expectedUrl;
        this.expectedUrl = configProperties.base_url() + expectedUrl;

        //initelement create a elements (physical writes objrcts, method ehich create objects)
        //PageFactory - physical initialization of the realization
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected",webDriver.getCurrentUrl(), expectedUrl);
            //Assert.assertEquals("message when AR != ER", "actual result", "expected result")
        } catch (Exception e) {
            logger.error("Cannot get url");
            Assert.fail("Cannot get url");
        }
    }
}

