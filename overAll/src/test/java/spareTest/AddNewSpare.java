package spareTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
	final private String TEST_SPARE = "Spare12";
	
	@Before
	public void beforeAddNewSpare(){
		loginPage.loginUser("Student", "909090");
		mainPage.checkCurrentUrl();
		mainPage.clickOnMenuDictionary();
		mainPage.clickOnSubMenuSpare();
		sparesPage.checkCurrentUrl();
		sparesPage.deletingSpareUntilPresent(TEST_SPARE);
		check(TEST_SPARE + " - Spare should not be in list ", sparesPage.isSpareInList(TEST_SPARE), false);
	}

	@Test
	public void addNewSpare(){
		sparesPage.checkCurrentUrl();
		sparesPage.clickOnPlusButton();
		editSparePage.checkCurrentUrl();
		editSparePage.enterTextInToSpareNameInput(TEST_SPARE);
		editSparePage.selectTextInDropDownTypeOfSpare("Датчики");
		editSparePage.clickButtonCreate();
		sparesPage.checkCurrentUrl();
		checkAC("Can not find spare in list ", sparesPage.isSpareInList(TEST_SPARE), true);

	}

	@After
	public void afterAddNewSpare(){
		sparesPage.deletingSpareUntilPresent(TEST_SPARE);
		check(TEST_SPARE + " Spare should not be in list ", sparesPage.isSpareInList(TEST_SPARE), false);
	}
}
