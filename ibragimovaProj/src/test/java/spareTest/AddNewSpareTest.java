package spareTest;


import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    @Test
    public void addNewSpare (){
        loginPage.openLoginPage();
        loginPage.enterTextIntoInputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();
//        mainPage.isAvatarPresent()
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
        try { // Метод остановки.этой конструкцией мы говорим джаве усни, чтобы успеть выбрать программц, которая не загрузилась.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.clickOnMenuSpare();
        mainPage.checkCurrentUrl();



    }

}

