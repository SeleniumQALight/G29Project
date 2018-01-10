package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparatPage {
    WebDriver webDriver;

    final String apparatNumber = "0";
    final String apparatComment = "Не трогать этот аппарат";


    public String isApparatNamePresent() {
        return webDriver.findElement(By.id("userProfileEdit_user_name")).getAttribute("value");
    }

    public String isApparatNumberPresent() {
        return webDriver.findElement(By.id("userProfileEdit_user_email")).getAttribute("value");


    }


}