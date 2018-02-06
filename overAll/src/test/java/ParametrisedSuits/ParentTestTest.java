package ParametrisedSuits;

import Pages.*;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static ParametrisedSuits.SuitLoginPage1.myCharParameter;

public class ParentTestTest {
    private WebDriver driver;
    private Logger log = Logger.getLogger(getClass());
    private Utils utils = new Utils();

    private boolean isTestPass = false;

    private String pathToScreenShot;
    private String browser;

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected WorkersPage workersPage;
    protected EditWorkerPage editWorkerPage;
    protected SparesPage sparesPage;
    protected EditSparePage editSparePage;

    @Before
    public void setUp() {

        browser = myCharParameter;
        if ("chrome".equals(browser)) {
            log.info("Chrome will be started");
            File fileFF = new File(".././drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            driver = new ChromeDriver();
            log.info(" Chrome is started");
        } else if ("iedriver".equals(browser)) {
            log.info("IE will be started");
            File file1 = new File(".././drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver();
            log.info(" IE is started");
        }
    }
    @After
    public void tearDown() {
            driver.quit();

    }
}
