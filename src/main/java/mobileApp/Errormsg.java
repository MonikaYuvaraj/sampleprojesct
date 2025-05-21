package mobileApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Errormsg {

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

		driver.findElement(By.xpath("//android.widget.TextView[@text='Search']")).click();
		Thread.sleep(3000);
		
		String t1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Please select state']")).getText();
		System.out.println(t1);
		
		String t2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Please select city\"]")).getText();
		System.out.println(t2);
		
		String t3 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Please select Check-in date\"]")).getText();
		System.out.println(t3);
		
		String t4 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Please select Check-out date\"]")).getText();
		System.out.println(t4);
		
		String t5 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Please select no. of rooms\"]")).getText();
		System.out.println(t5);
		
		String t6 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Please select no. of adults\"]")).getText();
		System.out.println(t6);
		
		
	}

}
