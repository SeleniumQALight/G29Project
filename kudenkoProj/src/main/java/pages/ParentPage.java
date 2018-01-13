package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import static libs.ActionsWithOurElements.*;

public class ParentPage {
    protected Logger logger;

    WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
        //ActionsWithOurElements actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
