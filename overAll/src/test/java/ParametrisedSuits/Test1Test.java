package ParametrisedSuits;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class Test1Test extends ParentTestTest{

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")

    public static Iterable < Object[] > params() {

            return Arrays.asList(new Object[][] {
                    { 0, 0 }, { 1, 1 }
            });

    }

    @Parameterized.Parameter() // first data value (0) is default
    public /* NOT private */ int fInput1;

    @Parameterized.Parameter(1)
    public /* NOT private */ int fExpected1;

    @Test
    public void test1() {
        System.out.println(fInput1 +" -- "+ fExpected1);
    }
}
