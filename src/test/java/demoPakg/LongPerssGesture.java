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
import io.appium.java_client.android.Activity;

public class LongPerssGesture extends BaseTest {

	@Test
	public void LongPress() throws MalformedURLException, InterruptedException
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		LongPressAction(ele);
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000));
		String text=driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(text, "Sample menu");

	}
}
