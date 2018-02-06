package spare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{
	final private String TEST_SPARE = "Spare12";
	
	public AddNewSpare(String browser) {
		super(browser);
	}

	@Before
	public void preparationOfData(){
		loginPage.loginUser("Student", "909090");
		homePage.checkIfThisPageIsOpened();
		homePage.clickMenuDictionary();
		homePage.clickSparesSubMenu();
		sparesPage.checkIfThisPageIsOpened();
		sparesPage.checkTitleH1PresentOnPageWithText("Запчасти Список");
		while (sparesPage.isSpareInList(TEST_SPARE)) {
			sparesPage.clickOnSpare(TEST_SPARE);
			editSparePage.clickOnButtonDelete();
		}
		checkAC(TEST_SPARE + " - Spare should not be in list ", sparesPage.isSpareInList(TEST_SPARE), false);

	}

	@Test
	public void addNewSpare(){
		sparesPage.checkTitleH1PresentOnPageWithText("Запчасти Список");
		sparesPage.clickOnPlusButton();
		editSparePage.checkIfThisPageIsOpened();
		editSparePage.checkTitleH1PresentOnPageWithText("Словарь");
		editSparePage.enterTextInToSpareNameInput(TEST_SPARE);
		editSparePage.selectTextInDropDownTypeOfSpare("Датчики");
		editSparePage.clickButtonCreate();
		sparesPage.checkIfThisPageIsOpened();
		sparesPage.checkTitleH1PresentOnPageWithText("Запчасти Список");
		checkAC("Can not find spare in list ", sparesPage.isSpareInList(TEST_SPARE), true);

	}

	@After
	public void deletionOfData(){
		while (sparesPage.isSpareInList(TEST_SPARE)) {
			sparesPage.clickOnSpare(TEST_SPARE);
			editSparePage.clickOnButtonDelete();
		}
		checkAC(TEST_SPARE + " Spare should not be in list ", sparesPage.isSpareInList(TEST_SPARE), false);
	}
}
