package pages;

import libs.ActionsWithOurElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static libs.ActionsWithOurElement.*;  //* vse metody v klasse zaimporili s pom *

public class ParentPage {
WebDriver webDriver;
ActionsWithOurElement actionsWithOurElement;

    protected Logger logger;


    String expectedUrl;
    public ParentPage(WebDriver webDriver,String expectedUrl) {
        this.webDriver = webDriver;
       logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this);
        actionsWithOurElement=new ActionsWithOurElement(webDriver);
        this.expectedUrl="http://v3.test.itpmgroup.com"+ expectedUrl;
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected",webDriver.getCurrentUrl(),expectedUrl);

        } catch (Exception e) {

        logger.error("Can not get url");
            Assert.fail("Can not get page");
    }
    }
}