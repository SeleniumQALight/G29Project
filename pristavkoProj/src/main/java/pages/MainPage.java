package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage{

    public MainPage (WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        try {
            return webDriver.findElement(By.xpath(".//img[@alt='Student']")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMenuPresent() {
        try {
            boolean mainMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/dashboard']")).isDisplayed();
            boolean dictionaryMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/dictionary/service']")).isDisplayed();
            boolean serviceMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/dictionary/service']")).isDisplayed();
            boolean installationMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/dictionary/installation']")).isDisplayed();
            boolean dealMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/deal']")).isDisplayed();
            boolean reportMenuItemPresent = webDriver.findElement(By.xpath(".//a[@href='/statistic']")).isDisplayed();
            boolean isAllMenuPresent = mainMenuItemPresent & dictionaryMenuItemPresent & serviceMenuItemPresent & installationMenuItemPresent & dealMenuItemPresent & reportMenuItemPresent;

            return isAllMenuPresent;
        } catch (Exception e) {
            return false;
        }
    }


}

