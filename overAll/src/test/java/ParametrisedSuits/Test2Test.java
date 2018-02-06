package ParametrisedSuits;


import com.github.peterwippermann.junit4.parameterizedsuite.ParameterContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ParametrisedSuits.SuitLoginPage1.myCharParameter;

@RunWith(Parameterized.class)
public class Test2Test extends ParentTestTest {
    static List test;

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")

    public static Iterable < Object[] > params() {

//        if (ParameterContext.isParameterSet()) {
//
//            return Collections.singletonList(ParameterContext.getParameter(Object[].class));
//
//        } else {
        test = Arrays.asList(Collections.singletonList(ParameterContext.getParameter(Object[].class)));
            return Arrays.asList(new Object[][] {
                    { 0, 0 }, { 1, 1 }
            });

//        }

    }

    @Parameterized.Parameter() // first data value (0) is default
    public /* NOT private */ int fInput1;

    @Parameterized.Parameter(1)
    public /* NOT private */ int fExpected1;

    @Test
    public void test2() {

        System.out.println("test " + myCharParameter);
        System.out.println(fInput1 +" -- "+ fExpected1);

    }
}
