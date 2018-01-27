package pages;

import libs.ActionsWIthOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWIthOurElements.*;

public class ParentPage {
    WebDriver webDriver;
    ActionsWIthOurElements actionsWIthOurElements;
    protected Logger logger;
    String expectedUrl;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements (webDriver, this);
        actionsWIthOurElements = new ActionsWIthOurElements(webDriver);
        this.expectedUrl = configProperties.base_url() + expectedUrl; // здесь раньше прописывали доменное имя, а теперь используем пропертиз, где прописано доменное имя
        // каждая пейджа будет создавать значение для этой переменной и будет сюда его передавать
    }
    //метод будет проверять, что ожидаемaя страница имеет ожидаемый url
    public void checkCurrentUrl () {
        try {
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedUrl);

        } catch (Exception e) {
            logger.error("Can not get url");
            Assert.fail("Can not get url");
        }
    }
}
