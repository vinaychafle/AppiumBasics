package demoPakg;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;

public class ScrollFunction extends BaseTest {

	@Test
	public void ScrollMenu() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		Thread.sleep(2000);
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).ScrollIntoView(text(\"WebView\"));"));
		//((ele) driver).findElementByAndroidUIAutomator("new UiScrollable(new    UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
		//ScrollToEnd();
	     // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView").instance(0))");
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))"));
	}
}
