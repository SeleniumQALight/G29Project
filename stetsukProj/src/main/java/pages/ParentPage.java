package pages;

import libs.ActionsWithoutElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    WebDriver webDriver;
    ActionsWithoutElements actionsWithoutElements;
    protected Logger logger;
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithoutElements = new ActionsWithoutElements(webDriver);
    }

}
