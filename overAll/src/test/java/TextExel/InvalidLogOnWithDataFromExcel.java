package TextExel;



import libs.ConfigData;
import libs.SpreadsheetData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

//this test will run with parameters
@RunWith(value = Parameterized.class)
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass;

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0}, {1}, {2}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
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
