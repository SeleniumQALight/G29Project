package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    WebDriver webDriver;

    protected Logger logger;

    public ParentPage(WebDriver webDriver){  //конструктор не возвращает значения и называется как класс (создается с помощью Alt + insert)
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }
}
