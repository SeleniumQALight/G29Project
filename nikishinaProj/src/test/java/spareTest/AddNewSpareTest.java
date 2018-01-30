package spareTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
//    объявить константу имени запчасти
    final String SPARE_NAME = "Spares for Lidiia";
    final String SPARE_TYPE = "Датчики";

    /**
     * TC - Adding of new Spare
     1. Preconditions:
     1.1 Open http://v3.test.itpmgroup.com
     1.2 Login with credentials login - Student, password - 909090
     1.3 Click Dictionaries
     1.4 Click Spares section
     1.5 Check if there is spares with name "Spares for Lidiia" and type "Датчики", delete all present

     2. Test:
     2.1 Click Plus button
     2.2 Enter valid spare name "Spares for Lidiia" into input Spare Name
     2.3 Choose spare type "Датчики" from dropdown
     2.4 Push Submit button
     2.5 Expected Result: Added spare with name "Spares for Lidiia" is on the list in Spares section

     3. Postconditions:
     3.1 Delete added spare named "Spares for Lidiia" from the list
     */

    @Before
    public void checkAndDeleteSpareWithSameName () {
        loginPage.loginUser("Student", "909090");
//        mainPage.isAvatarPresent(); // этот метод возвращает только тру или фолс, поэтому надо добавить проверку, что мы попали на мейнпейдж
//      вместо проверки выше делаем проверку текущего урла. в днном случае должен быть урл главной страницы, потому что после авторизации
//      в системе мы попадаем на главную страницу
        mainPage.checkCurrentUrl();
        mainPage.clickOnMenudictionary();
//        try {
//            Thread.sleep(5000); //подчеркнуло красным, комбинация алльт + энтер - выбрали второй пункт трай и кетч
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        mainPage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.deleteSpareWhilePresent(SPARE_NAME);
    }

    @Test
    public void addNewSpare (){
        sparesPage.addNewSpare(SPARE_NAME, SPARE_TYPE);
//        sparesPage.isSparePresent(SPARE_NAME);
        Assert.assertTrue("Spare " + SPARE_NAME + " is not present", sparesPage.isSparePresent(SPARE_NAME));
    }

    @After
    public void deleteAddedSpare () {
            sparesPage.deleteSpareWhilePresent(SPARE_NAME);
    }
}