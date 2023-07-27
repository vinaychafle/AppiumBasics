package demoPakg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class Assignment extends BaseTest {

	@Test
	public void AssignmentDemo()
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
		
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons2ultra")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Satellite']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("VInay");
		driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("adbc");
		driver.findElement(By.id("android:id/button1")).click();
	}
}
