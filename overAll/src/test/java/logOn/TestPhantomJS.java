package logOn;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class TestPhantomJS {
    WebDriver driver ;
    Logger logger ;
	WebDriverWait webDriverWait;
    
    public TestPhantomJS (){
    	logger = Logger.getLogger(getClass());
    	
	}

    @Test
    public void testPhantomJS() {
//		File filePhantomJs = new File(".././drivers/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//		System.setProperty("phantomjs.binary.path", filePhantomJs.getAbsolutePath());
//		driver = new PhantomJSDriver();
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				".././drivers/phantomjs-2.1.1-windows/bin/phantomjs.exe"
		);
		driver = new  PhantomJSDriver(caps);
//		webDriverWait = new WebDriverWait(driver, 10);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1280, 1024));
	
		driver.get("http://v3.test.itpmgroup.com/login");
	
//		webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("_username"))));
		driver.findElement(By.name("_username")).clear();
		driver.findElement(By.name("_username")).sendKeys("Student");
		logger.info("Student was entered");
	
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("909090");
	
		driver.findElement(By.tagName("button")).click();
		Assert.assertTrue(driver.getTitle().equals("Учет запчастей"));
	
		logger.info("Page title is: " + driver.getTitle());
		
		logger.info("test ");
		driver.quit();
    }

}
