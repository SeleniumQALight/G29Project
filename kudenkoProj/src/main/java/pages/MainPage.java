package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver webDriver;


    public MainPage(WebDriver webDriver){

        this.webDriver = webDriver;

    }

    public boolean isAvatarPresent(){
        try{
           return  webDriver.findElement(By.xpath(".//img[@class='user-image']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void enterName(String name){
        webDriver.findElement(By.name("_username")).sendKeys(name);
    }

    public void enterPass(String password){
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void cliclElement(){
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
    }


}
