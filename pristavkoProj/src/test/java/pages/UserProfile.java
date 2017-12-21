package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserProfile {
    WebDriver webDriver;

    public UserProfile(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    final String userEmail = "alex@bigmir.net";
    final String userName = "StudentAlex";

    public boolean isNewUserNameInHeaderPresent() {
        try {
            return webDriver.findElement(By.xpath(".//p[text()='StudentAlex']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNewUserNamePresent() {
        try {
            String newUserEmail = webDriver.findElement(By.id("userProfileEdit_user_email")).getText();
            return (newUserEmail == userEmail);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNewUserEmailPresent() {
        try {
            String newUserName = webDriver.findElement(By.id("userProfileEdit_user_name")).getText();
            return (userName == newUserName);

        } catch (Exception e) {
            return false;
        }
    }


}