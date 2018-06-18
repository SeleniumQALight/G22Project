package logOn;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.SlowTests;
import parentTest.ParentTest;

@Category(SlowTests.class)
public class LoginTestWithHtmlElements extends ParentTest {
    public LoginTestWithHtmlElements(String browser) {
        super(browser);
    }

    @Test
    public void unvalidLogOn(){
        loginPage.openLoginPage();
        pageWithHtmlElements.enterTextLogin("test");
    }

}
