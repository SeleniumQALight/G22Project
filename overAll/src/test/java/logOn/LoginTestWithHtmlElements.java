package logOn;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.SlowTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import parentTest.ParentTest;

@Category(SlowTests.class)
public class LoginTestWithHtmlElements extends ParentTest {
    public LoginTestWithHtmlElements(String browser) {
        super(browser);
    }

    @Owner("Radulenko")
    @Feature("First feature")
    @Story("LoginTestWithHtmlElements")
    @Description("Descriptionsss")
    @Issue("3695")
    @Severity(SeverityLevel.BLOCKER)


    @Test
    public void unvalidLogOn(){
        loginPage.openLoginPage();
        loginPageWithHtmlElements.enterTextLogin("Student");
        loginPageWithHtmlElements.enterTextPass("909090");
        loginPageWithHtmlElements.clickButtonLogin();
        homePageWithHtmlElements.leftMenuСlickMenuDictionary();
        homePageWithHtmlElements.leftMenuСlickSubMenuSpare();

    }

}
