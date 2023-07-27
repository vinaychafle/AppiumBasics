package demoPakg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class DragAndDropDemo extends BaseTest {

	@Test
	public void SwipeImage() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		DragAndDrop(source, 620, 560);
		Thread.sleep(3000);
		String text=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(text, "Dropped!");
	}
}
