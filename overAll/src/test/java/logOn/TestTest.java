package logOn;

import org.junit.Test;


public class TestTest extends TestWithParametersFromCommandLine {

    public TestTest(String parameter) {
        super(parameter);

    }


    @Test
    public void tc1(){
        System.out.println(parameter);
        System.out.println("---");
    }
}
