package spareTest;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {

    @Test
    public void addNewSpare() {
        loginPage.loginUser("Student", "909090");
       // loginPage.openLoginPage();

        mainPage.checkCurrentUrl();

        loginPage.enterTextIntoInputLogin(loginPage.getLogin());
        loginPage.enterTextIntoInputPassword(loginPage.getPassword());
        loginPage.clickOnSubmitButton();

/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // impelemt this methods

        webDriver.findElement(By.id("dictionary")).click();
        webDriver.findElement(By.id("spares")).click();
/*        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();*/

    }

}
