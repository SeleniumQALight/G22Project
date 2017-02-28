package parentTest;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;

@RunWith(value = Parameterized.class)
public class ParentTest {
    private WebDriver driver;
    private Logger log = Logger.getLogger(getClass());

    private boolean isTestPass = false;

    private String pathToScreenShot;
    private String browser;
    protected String browserForIgnoreBug;

    public ParentTest(String browser) {
        this.browser = browser;
        browserForIgnoreBug = this.browser;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"fireFox"}
                ,
                {"chrome"}
//                ,
//                { "iedriver" }
//                ,
//                    { "opera" }
        });
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void SetUp() {
        File file = new File("");

        if ("fireFox".equals(browser)) {
            System.out.println("FireFox will be started");
            File fileFF = new File("./drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            driver = new FirefoxDriver();
            System.out.println(" FireFox is started");
        } else if ("chrome".equals(browser)) {
            System.out.println("Chrome will be started");
            File fileFF = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            driver = new ChromeDriver();
            System.out.println(" Chrome is started");
        } else if ("iedriver".equals(browser)) {
            System.out.println("IE will be started");
            File file1 = new File("./drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver();
            System.out.println(" IE is started");
        } else if ("opera".equals(browser)) {
            System.out.println("Opera will be started");
            File fileOpera = new File("./drivers/operadriver.exe");
            System.setProperty("webdriver.chrome.driver", fileOpera.getAbsolutePath());
            driver = new ChromeDriver();
            System.out.println(" Opera is started");
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @After
    public void tearDown() {
        if (!(driver == null)) {
            driver.quit();
        }
    }


    public void checkAC(String message, String actual, String expected) {
        if (!actual.equals(expected)) {

            log.error("AC failed: " + message);
        }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
        setTestPass();
    }

    public void checkAC(String message, Boolean actual, Boolean expected) {
        if (!(actual == expected)) {

            log.error("AC failed: " + message);
        }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actual, is(expected));
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }


}
