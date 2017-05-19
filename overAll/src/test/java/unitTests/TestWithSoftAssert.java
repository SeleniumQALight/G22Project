package unitTests;


import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import libs.MySoftAssert;


public class TestWithSoftAssert {
    private Logger logger ;
    
    public TestWithSoftAssert(){
        logger = Logger.getLogger("TestUnitTestWithMock");
    }
    
    @Rule
    public MyCustomRule myCustomRule = new MyCustomRule();

    @Test
    public void testMultiplyException() {
        
        //Example softAssert with more usefully message
        MySoftAssert mySoftAssert = new MySoftAssert();
         mySoftAssert.assertEqualsWithMessage(true, false,"Text from SoftAssert1");
         mySoftAssert.assertEqualsWithMessage(5, 10,"Text from SoftAssert2");
         mySoftAssert.assertEqualsWithMessage(4, 9," Text Soft Assert 3");
        mySoftAssert.assertAll();
    
        // This is example with custom softAssert
        SoftAssert  softAssert = new SoftAssert();
            softAssert.assertEquals(4,6,"Custom softAssert text1");
            softAssert.assertEquals(6,8,"Custom softAssert text1");
        softAssert.assertAll();
    }

}
