package pages;

import libs.ActionsWIthOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWIthOurElements.*;

public class ParentPage {
    WebDriver webDriver;
    ActionsWIthOurElements actionsWIthOurElements;
    protected Logger logger;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements (webDriver, this);
        actionsWIthOurElements = new ActionsWIthOurElements(webDriver);
    }


}
