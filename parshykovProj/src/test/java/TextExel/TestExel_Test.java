package TextExel;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static libs.ConfigData.getCfgValue;

public class TestExel_Test {
	private ExcelDriver excelDriver;

	static private Logger log = Logger.getLogger(TestExel_Test.class);

	@Before
	public void setUp() throws Exception {
		excelDriver = new ExcelDriver();
		log.info("--------- TEST STARTED -------------");
	}

	@Test
	public void test6() throws Exception {

		Map dataTestList1 = excelDriver.getData(getCfgValue("DATA_FILE"), "List1");

		log.info("TestData :" + dataTestList1);
		 
		
		Map<String,String> dataStatic = excelDriver.getData(getCfgValue("DATA_FILE"), "List1");
		
		log.info("testStaticData " + dataStatic.get("KursItem2"));

	}

	@After
	public void tearDown() throws Exception {

		log.info("--------- TEST END  -------------");
	}
}
