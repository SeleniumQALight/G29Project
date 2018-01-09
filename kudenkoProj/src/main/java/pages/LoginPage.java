package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }

    public void enterName(String name){
        try {
            webDriver.findElement(By.name("_username")).clear();
            webDriver.findElement(By.name("_username")).sendKeys(name);
            logger.info("Login was inputed into input");
        }catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
        }

    public void enterPass(String password){
        webDriver.findElement(By.id("password")).sendKeys(password);
    }


    public void cliclElement(){
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
    }


}
