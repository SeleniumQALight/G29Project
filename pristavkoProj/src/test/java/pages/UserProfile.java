package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfile {
    WebDriver webDriver;

    public UserProfile(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isNewUserNameInHeaderPresent() {
        try {
            return webDriver.findElement(By.xpath(".//p[text()='StudentAlex']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public String getNewUserName() {
        return webDriver.findElement(By.id("userProfileEdit_user_name")).getAttribute("value");
    }

    public String getNewUserEmailPresent() {
        return webDriver.findElement(By.id("userProfileEdit_user_email")).getAttribute("value");
    }


}