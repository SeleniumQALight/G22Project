package DBTest;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDataBase_Test {
	static Logger log = Logger.getLogger(TestDataBase_Test.class);
	static Database dBMySQL;

	@Before
	public void setUp() throws Exception {
		log.info("--- Conect MySQL DB --------");
		dBMySQL = new Database("MySQL_PADB_DB", "MySQL");
		log.info("--- Conected to MySQL --------");
		log.info("--- Test STARTED --------");

	}

	@Test
	public void Teas1() throws SQLException, ClassNotFoundException, IOException {

		List<Map<String, String>> testMySQLValue = dBMySQL.selectTable("select * from table_selenium ");
		log.info("value -- " + testMySQLValue);

	}

	@After
	public void tearDown() throws Exception {
		dBMySQL.quit();
		log.info(" ----- Test END  -----");
	}

}
