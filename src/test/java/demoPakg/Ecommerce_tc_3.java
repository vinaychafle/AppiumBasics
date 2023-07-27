package demoPakg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerce_tc_3 extends BaseTest {
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

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		
		List<WebElement> ele=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=ele.size();
		double Totalsum=0;
		for(int i=0;i<count;i++)
		{
			String amountString=ele.get(i).getText();
			Double price=getFormattedString(amountString);
			Totalsum=price+Totalsum;
		}
		String displayString=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double DisplaySum=getFormattedString(displayString);
		Assert.assertEquals(Totalsum, DisplaySum);
		WebElement terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(terms);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
	}

}
