package pages;

import libs.ActionsWithOurElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWithOurElement.*;  //заімпортили вручну лібс і її методи

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElement actionsWithOurElement;
    protected Logger logger;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElement = new ActionsWithOurElement(webDriver);
    }


}
