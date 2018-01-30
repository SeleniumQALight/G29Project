package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.openLoginPage();                      //eti 4 metoda zamenit' posle sozdaniya domawki na loginPage.loginUser("Student","909090");
        loginPage.enterTextIntoImputLogin("Student");
        loginPage.enterTextIntoInputPass("909090");
        loginPage.clickOnSubmitButton();

        mainPage.checkCurentUrl();
        mainPage.clickOnMenuDictionary();
//        try {
//            Thread.sleep (5000); // indyskii sposob zadergki
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurentUrl();
        sparesPage.clickOnPlusButton(); //dz dopisat'
    }
}
