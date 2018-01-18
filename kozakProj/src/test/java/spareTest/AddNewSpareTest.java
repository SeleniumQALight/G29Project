package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {

    @Test
    public void addNewSpare(){
        loginPage.loginUser("Student","909090");
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
//        try {                                   //
//            Thread.sleep(5000);                 // зупинка потоку на конкретний час (неявне очікування)
//        } catch (InterruptedException e) {      //
//            e.printStackTrace();                //
//        }
        mainPage.clickOnMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnPlusButton();



    }

}
