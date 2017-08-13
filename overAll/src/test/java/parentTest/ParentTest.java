package parentTest;

import Pages.EditSparePage;
import Pages.EditWorkerPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SparesPage;
import Pages.WorkersPage;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import unitTests.MyCustomRule;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;

@RunWith(value = Parameterized.class)
public class ParentTest {
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

    public ParentTest(String browser) {
        this.browser = browser;

    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
 //              {"fireFox"}
////                ,
//                {"chrome"}
//                ,
//                { "iedriver" }
//                ,
//                    { "opera" }
//                ,
//                {"phantomJs"}
//                ,
                {"remote"}
        });
    }

    @Rule
    public TestName testName = new TestName();
    
    @Rule
    public MyCustomRule myCustomRule = new MyCustomRule();

    @Before
    public void SetUp() {
        File file = new File("");

        if ("fireFox".equals(browser)) {
            log.info("FireFox will be started");
            File fileFF = new File(".././drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("browser.startup.page", 0); // Empty start page
            profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            driver = new FirefoxDriver(profile);
            log.info(" FireFox is started");
        } else if ("chrome".equals(browser)) {
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
        } else if ("opera".equals(browser)) {
            log.info("Opera will be started");
            File fileOpera = new File(".././drivers/operadriver.exe");
            System.setProperty("webdriver.chrome.driver", fileOpera.getAbsolutePath());
            driver = new ChromeDriver();
            log.info(" Opera is started");
        } else if ("phantomJs".equals(browser)){
            log.info("PHANTOMJS will be started");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability("takesScreenshot", true);
            caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    ".././drivers/phantomjs-2.1.1-windows/bin/phantomjs.exe"
            );
            driver = new PhantomJSDriver(caps);
            log.info(" PHANTOMJS is started");
        } else if ("remote".equals(browser)){
            log.info("Remote Driver will be started");
            try {
                driver = new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"),
                        DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshot\\" + this.getClass().getPackage().getName()
                + "\\" + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + "-" + browser + ".jpg";
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().setSize(new Dimension(1900, 1080));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        workersPage = new WorkersPage(driver);
        editWorkerPage = new EditWorkerPage(driver);
        sparesPage = new SparesPage(driver);
        editSparePage = new EditSparePage(driver);


    }

    @After
    public void tearDown() {
        if (!(driver == null)) {
            if (!isTestPass) {
                utils.screenShot(pathToScreenShot, driver);
            }
            driver.quit();
        }
    }


    protected void checkAC(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            utils.screenShot(pathToScreenShot, driver);
            log.error("AC failed: " + message);
        }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
        setTestPass();
    }

    protected void checkAC(String message, Boolean actual, Boolean expected) {
        if (!(actual == expected)) {
            utils.screenShot(pathToScreenShot, driver);
            log.error("AC failed: " + message);
        }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }


}
