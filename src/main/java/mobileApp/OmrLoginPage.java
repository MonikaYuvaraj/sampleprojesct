package mobileApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class OmrLoginPage {
	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("appium:deviceName", "9648454630000QH");
		cap.setCapability("appium:packageName", "com.omr_branch");
		cap.setCapability("appium:activityName", "com.omr_branch.MainActivity");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("platformName", "Android");

		WebDriver driver = new AppiumDriver(cap);

		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email Address']"));
		email.sendKeys("monikayuvaraj145@gmail.com");

		WebElement pass = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']"));
		pass.sendKeys("Monika112@");

		WebElement login = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
		login.click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select State']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Andhra Pradesh']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select City']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Tirupati']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Room Type']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Standard']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkin']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkout']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Room']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='1-One']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Adults']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='1-One']")).click();
		Thread.sleep(3000);

		WebElement e2 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_no_of_children']"));
		Thread.sleep(3000);
		e2.sendKeys("2");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text='Search']")).click();
		Thread.sleep(3000);

		WebElement e3 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='header_welcome']"));
		String t1 = e3.getText();
		System.out.println(t1);

		WebElement e4 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='select_hotel_text']"));
		String t2 = e4.getText();
		System.out.println(t2);

	}

}
