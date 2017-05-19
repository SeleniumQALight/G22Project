package unitTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;

public class TestUnitTestWithMock {

    @Rule
    public MyCustomRule myCustomRule = new MyCustomRule();

    @Test
    public void testMultiplyException() {

        ClassToBeTestedByUnitTest classToBeTestedByUnitTest = mock(ClassToBeTestedByUnitTest.class);

        when(classToBeTestedByUnitTest.multiply(anyInt(),anyInt())).thenReturn(4);

        assertEquals("Mock Results", 4, classToBeTestedByUnitTest.multiply(1, 2));
    }

}
