package demoPakg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		AppiumDriverLocalService service=	new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\vchafle\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\vchafle\\Downloads\\chromedriver_win32\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");
		
		options.setDeviceName("Nexus 5X API 30");
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	
	public double getFormattedString(String amountString)
	{
		double price=Double.parseDouble(amountString.substring(1));
		return price;
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//service.close();
	}
}
