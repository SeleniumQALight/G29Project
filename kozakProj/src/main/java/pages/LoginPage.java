package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void  openLoginPage (){  //метод що відкриває урл логін пейджи
        try {
             webDriver.get("http://v3.test.itpmgroup.com");
             logger.info ("Login page was opened");              // пише в лог
         } catch  (Exception e){                                 // відловлює  ексепшени
            logger.error("Can not open url");                    // пише в лог
            Assert.fail("Can not open url ");                    //  пише в отчет про запуск теста
        }
    }

        public void  enterTextIntoInputLogin(String login){      //створили змінну
        try{
            webDriver.findElement(By.name("_username")).clear();   //чистимо логін
            webDriver.findElement(By.name("_username")).sendKeys(login);  //водимо логін
            logger.info(login + " was inputed in to input ");      // пише в лог
        } catch  (Exception e){                                    // відловлює  ексепшени
            logger.error("Can not work with element");             // пише в лог
            Assert.fail("Can not work with element");              //  пише в отчет про запуск теста
        }
        }

}
