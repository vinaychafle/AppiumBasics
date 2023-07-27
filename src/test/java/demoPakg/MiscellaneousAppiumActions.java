package demoPakg;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumActions extends BaseTest {

	//to find package name and activity name use for windows = adb shell dumpsys window | find "mCurrentFocus"
	@Test
	public void Miscellenaous() throws MalformedURLException
	{
		Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
		driver.startActivity(activity);
		
		//Activity ac = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//driver.startActivity(ac);
		
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//copy paste
		//copy to clipboard- paste to clipboard 
		driver.setClipboardText("burn WIFI");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
}
