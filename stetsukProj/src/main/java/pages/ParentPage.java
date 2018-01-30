package pages;

import libs.ActionsWithoutElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    WebDriver webDriver;
    ActionsWithoutElements actionsWithoutElements;
    protected Logger logger;
    String expectedUrl;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected static final String baseUrl = configProperties.base_url();


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = configProperties.base_url() + expectedUrl;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
        actionsWithoutElements = new ActionsWithoutElements(webDriver);

    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedUrl);
        } catch (Exception e) {
            logger.error("Can not get url");
            Assert.fail("Can not get url");
        }
    }
}
