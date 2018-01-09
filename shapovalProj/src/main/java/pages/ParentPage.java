package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver webDriver;
   protected Logger logger;                 // vubrat' loger apa4 log 4 j!!!!


    public ParentPage(WebDriver webDriver) {// konstryktor nastoiki
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }
}
