package logOn;

import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


public class TestWithParametersFromCommandLine {

    // runner should have parameter in VM options -> -Dbrowsers=chrome,ff

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        String browsers = System.getProperty("browsers");
        String[] arrayBrowser = browsers.split(",");
        String[][] tempMass = new String[arrayBrowser.length][1];
        for (int i = 0; i < arrayBrowser.length; i++) {
            tempMass[i][0] = arrayBrowser[i];
        }
        return Arrays.asList(tempMass);
    }


    String parameter;

    public TestWithParametersFromCommandLine(String parameter) {
        this.parameter = parameter;
    }



}
