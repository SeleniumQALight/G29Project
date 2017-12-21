package mainPageTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Test Case 3
 */

import java.util.concurrent.TimeUnit;

public class UpdateUserProfile extends ParentTest {

    final String url = "http://v3.test.itpmgroup.com/login";
    final String login = "Student";
    final String password = "909090";
    final String userEmail = "alex@bigmir.net";
    final String userName = "StudentAlex";

    @Test
    public void successUserProfileUpdate() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.get(url);
        webDriver.findElement(By.name("_username")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//span[@class='hidden-xs']")).click();
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(".//a[@href='/users/profile/13']")).click();
        webDriver.findElement(By.xpath(".//input[@name='userProfileEdit[user][email]']")).clear();
        webDriver.findElement(By.xpath(".//input[@name='userProfileEdit[user][email]']")).sendKeys(userEmail);
        webDriver.findElement(By.xpath(".//*[@id='userProfileEdit_user_name']")).clear();
        webDriver.findElement(By.xpath(".//*[@id='userProfileEdit_user_name']")).sendKeys(userName);
        webDriver.findElement(By.xpath(".//button[@name='save']")).click();
        webDriver.findElement(By.xpath(".//span[@class='hidden-xs']")).click();
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(".//a[@href='/logout']")).click();
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        webDriver.findElement(By.name("_username")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//span[@class='hidden-xs']")).click();
        webDriver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath(".//a[@href='/users/profile/13']")).click();

        Assert.assertTrue("User name in left side of the page is not updated", userProfile.isNewUserNameInHeaderPresent());
        Assert.assertTrue("Email in user profile is not updated", userProfile.isNewUserNamePresent());
        Assert.assertTrue("Name in user profile is not updated", userProfile.isNewUserEmailPresent());

    }

}