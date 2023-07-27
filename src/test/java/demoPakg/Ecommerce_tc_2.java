package demoPakg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerce_tc_2 extends BaseTest {
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Isabell Clark");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Argentina\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\").instance(0))"));
		int prodcount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<prodcount;i++)
		{
			String productname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productname.equalsIgnoreCase("Jordan 6 Rings"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		String Addedprod=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(Addedprod, "Jordan 6 Rings");
	}

}
