package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

public class TestUnitTest {

    @Rule
    public MyCustomRule myCustomRule = new MyCustomRule();

    @Test
    public void testMultiplyException() {
        ClassToBeTestedByUnitTest classToBeTestedByUnitTest = new ClassToBeTestedByUnitTest();
        assertEquals("Results", 2, classToBeTestedByUnitTest.multiply(1, 2));
    }

}
