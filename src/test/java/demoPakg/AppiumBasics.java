package demoPakg;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@index='9']")).click();
		//Activity ac = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(ac);
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("burn WIFI");
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		
	}
}
