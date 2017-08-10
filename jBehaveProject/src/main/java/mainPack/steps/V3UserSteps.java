package mainPack.steps;

import mainPack.pages.DictionaryPage;
import mainPack.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class V3UserSteps extends ScenarioSteps {

    LoginPage loginPage;

//    @Step
//    public void enters(String keyword) {
//        dictionaryPage.enter_keywords(keyword);
//    }
//
//    @Step
//    public void starts_search() {
//        dictionaryPage.lookup_terms();
//    }
//
//    @Step
//    public void should_see_definition(String definition) {
//        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
//    }

    @Step
    public void is_the_login_page() {
        loginPage.open();
    }

//    @Step
//    public void looks_for(String term) {
//        enters(term);
//        starts_search();
//    }
}