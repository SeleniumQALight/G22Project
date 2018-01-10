package spare;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{
	final private String TEST_SPARE = "Spare12";
	
	public AddNewSpare(String browser) {
		super(browser);
	}
	
	@Test
	public void addNewSpare(){
		loginPage.loginUser("Student", "909090");
		homePage.checkIfThisPageIsOpened();
		homePage.clickMenuDictionary();
		homePage.clickSparesSubMenu();
		sparesPage.checkIfThisPageIsOpened();
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
		sparesPage.clickOnSpare(TEST_SPARE);
		editSparePage.clickOnButtonDelete();
		checkAC("Spare should not be in list ", sparesPage.isSpareInList(TEST_SPARE), false);
	}
}
