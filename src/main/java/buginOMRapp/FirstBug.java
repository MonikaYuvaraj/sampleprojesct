package buginOMRapp;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import omrHotelBooking.BaseClassMob;

public class FirstBug extends BaseClassMob{

	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("appium:deviceName", "9648454630000QH");
		cap.setCapability("appium:packageName", "com.omr_branch");
		cap.setCapability("appium:activityName", "com.omr_branch.MainActivity");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("platformName", "Android");

		driver = new AppiumDriver(cap); // Assign to the static variable in BaseClassMob

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email Address']"));
		email.sendKeys("monikayuvaraj145@gmail.com");

		WebElement pass = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']"));
		pass.sendKeys("Monika112@");

		WebElement login = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
		login.click();
		
		String ExploreHotel = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"search_explore_hotel\"]")).getText();
		System.out.println(ExploreHotel);
		
		
		//Assert.assertEquals(ExploreHotel, "ExploreHotel", "Verified");
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"header_welcome\"]")).click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"search_option_account_setting_title\"]")).click();
		
		driver.findElement(By.xpath("//android.widget.ImageView[@resource-id=\"header_back_image\"]")).click();
		
		Assert.assertEquals(ExploreHotel,"Crashed");

		
	
	}
}
