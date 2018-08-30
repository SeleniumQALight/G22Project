package StepDefinitions;


import Selenium.SeleniumFunctions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {
    SeleniumFunctions sf = new SeleniumFunctions();

    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println( "--------- Scenario "  + scenario.getName() + " started -------- \n ");

            sf.createDriver();

    }

    @After
    public void embedScreenshot(Scenario scenario) throws IOException {
        sf.teardown();
        System.out.println( "--------- Scenario "  + scenario.getName() + " finished -------- \n ");

    }

}
