package spareTest;


import org.junit.Test;
import pages.ParentPage;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    @Test
    public  void addNewSpare(){
        loginPage.loginUser("Student", "909090");
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenuDictionary();
//        try {
//            Thread.sleep(5000); // BAD IDEA!!!
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        mainPage.clickOnSubMenuSpare();
        sparesPage.clickOnPlusButton();
        sparesPage.addSpareAndDelete("Brusov`sTestSpare", "Механика");
        sparesPage.checkCurrentUrl();


    }
}
