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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		AppiumDriverLocalService service=	new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\vchafle\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		
		
		options.setDeviceName("Nexus 5X API 30");
		options.setChromedriverExecutable("C:\\Users\\vchafle\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//options.setApp("C:\\Users\\vchafle\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		//options.setApp("C:\\Users\\vchafle\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		options.setApp("C:\\Users\\vchafle\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\Stock_Trainer.apk");
		
	    driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	public void LongPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
	}
	
	public void ScrollToEnd()
	{
		boolean canScrollMore;
		do {
	    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	public void SwipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void DragAndDrop(WebElement ele,int A,int B)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", A,
			    "endY", B
			));
	}
	
	public void scrollTOtext(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))"));
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
