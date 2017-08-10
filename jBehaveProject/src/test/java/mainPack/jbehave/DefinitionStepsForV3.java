package mainPack.jbehave;

import mainPack.steps.EndUserSteps;
import mainPack.steps.V3UserSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DefinitionStepsForV3 {

    @Steps
    V3UserSteps v3UserSteps;

    @Given("the user is on the V3 home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        v3UserSteps.is_the_login_page();
    }

//    @When("the user looks up the definition of the word '$word'")
//    public void whenTheUserLooksUpTheDefinitionOf(String word) {
//        endUser.looks_for(word);
//    }
//
//    @Then("they should see the definition '$definition'")
//    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
//        endUser.should_see_definition(definition);
//    }

}
