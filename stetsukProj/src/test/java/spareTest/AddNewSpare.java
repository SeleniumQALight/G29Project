package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{

    @Test
    public void addNewSpare() {
        loginPage.loginUser("Student","909090");
        mainPage.checkCurrentUrl();
        mainPage.clicOnMenuDictionary();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();

    }

}
