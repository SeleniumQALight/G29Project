package pages;

import Libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Libs.ActionsWithOurElements.*;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;

   protected Logger logger;                 // vubrat' loger apa4 log 4 j!!!!


    public ParentPage(WebDriver webDriver) {// konstryktor nastoiki
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
