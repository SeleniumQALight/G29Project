package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver webDriver;
    protected Logger logger;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }
}