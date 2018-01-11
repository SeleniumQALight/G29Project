package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static libs.ActionsWithOurElements.*;

public class ParentPage {
    WebDriver webDriver;

    protected Logger logger;

    public ParentPage(WebDriver webDriver){  //конструктор не возвращает значения и называется как класс (создается с помощью Alt + insert)
        ActionsWithOurElements actionsWithOurElements;
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }
}
