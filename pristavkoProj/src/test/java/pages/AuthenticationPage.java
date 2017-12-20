package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {
    WebDriver webDriver;

    public AuthenticationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean isMenuItemMainNotPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='/dashboard']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTitleAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//a[@href='http://v3.test.itpmgroup.com/']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isButtonLoginInAuthenticationPageIsPresent() {
        try {
            return webDriver.findElement(By.xpath(".//button[@type='submit']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

}

