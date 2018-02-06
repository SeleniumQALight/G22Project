package ParametrisedSuits;

import com.github.peterwippermann.junit4.parameterizedsuite.ParameterizedSuite;
import ParametrisedSuits.Test2Test;
import ParametrisedSuits.Test1Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(ParameterizedSuite.class)
@Suite.SuiteClasses(
        {
                Test1Test.class,
                Test2Test.class

                
        }
)
public class SuitLoginPage1 {
        public static String param;

        @Parameterized.Parameters(name = "Parameters are {0} ")
        public static Collection testData() throws IOException {
                String browsers = System.getProperty("browsers");
                String[] arrayBrowser = browsers.split(",");
                String[][] tempMass = new String[arrayBrowser.length][1];
                for (int i = 0; i < arrayBrowser.length; i++) {
                        tempMass[i][0] = arrayBrowser[i];
                }
                return Arrays.asList(tempMass);
        }


        /**

         * Always provide a target for the defined parameters - even if you only want to access them in the suite's child classes.

         * Instead of fields you can also use a constructor with parameters.

         */

        @Parameterized.Parameter(0)
        public static String myCharParameter;

        @BeforeClass
        public static void beofTestClass(){
                param = myCharParameter;
        }

}