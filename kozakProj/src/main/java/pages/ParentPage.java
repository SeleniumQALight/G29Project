package pages;

import libs.ActionsWithOurElement;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWithOurElement.*;  //заімпортили вручну лібс і її методи

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElement actionsWithOurElement;
    protected Logger logger;
    String expectedUrl;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);                       // ініціалізує елементи для @FindBy
        actionsWithOurElement = new ActionsWithOurElement(webDriver);
   //     this.expectedUrl = "http://v3.test.itpmgroup.com" + expectedUrl;
        this.expectedUrl = configProperties.base_url() + expectedUrl;   //тянемо доменний Url
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedUrl); //перевірка очікуваного результату до актуального
        } catch (Exception e) {
            logger.error("Can't get Url");
            Assert.fail("Can't get Url");
        }
    }

}
