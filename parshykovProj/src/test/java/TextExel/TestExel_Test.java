package TextExel;

import libs.ExcelDriver;
import libs.SpreadsheetData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import static libs.ConfigData.getCfgValue;

public class TestExel_Test {
	private ExcelDriver excelDriver;

	static private Logger log = Logger.getLogger(TestExel_Test.class);

	@Before
	public void setUp() throws Exception {
		excelDriver = new ExcelDriver();
		log.info("--------- TEST STARTED -------------");
	}

	@Test
	public void test6() throws Exception {

		Map dataTestList1 = excelDriver.getData(getCfgValue("DATA_FILE"), "List1");

		log.info("TestData :" + dataTestList1);
		 
		
		Map<String,String> dataStatic = excelDriver.getData(getCfgValue("DATA_FILE"), "List1");
		
		log.info("testStaticData " + dataStatic.get("KursItem2"));

	}

	@After
	public void tearDown() throws Exception {

		log.info("--------- TEST END  -------------");
	}

    //this test will run with parameters
    @RunWith(value = Parameterized.class)
    public static class InvalidLogOnWithDataFromExcel extends ParentTest {
        String login, pass;

        public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {
            super(browser);
            this.login = login;
            this.pass = pass;
        }

        @Parameterized.Parameters
        public static Collection testData() throws IOException {
            InputStream spreadsheet = new FileInputStream(getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
            return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
        }

        /*
            @Parameterized.Parameters
            public static Collection testDData(){
                return Arrays.asList(new Object[][]{
                    {"Student","906090"},
                    {"tudent","909090"}
                });
            }
        */
        @Test
        public void invalidLogOnWithDataFromExcel() {
            loginPage.openLoginPage();
            loginPage.enterLogin(login);
            loginPage.enterPass(pass);
            loginPage.clickButtonLogin();
            checkAC("Title not expected", loginPage.getTitle()
                    , "Account of spare:Авторизация");
        }



    }
}
