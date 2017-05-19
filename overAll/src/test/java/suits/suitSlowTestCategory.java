package suits;


import TextExel.InvalidLogOnWithDataFromExcel;
import logOn.LoginTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import categories.SlowTests;

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowTests.class)
@Suite.SuiteClasses({
		LoginTest.class,
		InvalidLogOnWithDataFromExcel.class
		
})
public class suitSlowTestCategory {
}
