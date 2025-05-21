package swipe;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import omrHotelBooking.BaseClassMob;

public class ExploreHotelSwip extends BaseClassMob {
	//static AppiumDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:deviceName", "9648454630000QH");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:appPackage", "com.omr_branch");
		capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
		capabilities.setCapability("appium:noReset", true);
		driver =new AppiumDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		elementSendKeys(By.xpath("//android.widget.EditText[@content-desc='Email Address']"), "monikayuvaraj145@gmail.com");

		WebElement pass = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']"));
		pass.sendKeys("Monika112@");

		WebElement login = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
		login.click();

		WebElement SelectState = driver.findElement(By.xpath("//android.widget.TextView[@text='Select State']"));
		SelectState.click();
		
		WebElement element = driver
				.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"search_select_state flatlist\"]"));
		
		swipeToDropDown(element);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Tamil Nadu\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select City']")).click();

		WebElement element2 = driver
				.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"search_select_city flatlist\"]"));
		swipeToDropDown(element2);
		WebElement element4 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Coimbatore\"]"));
		element4.click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Room Type']")).click();
		WebElement element3 = driver
				.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"search_room_type flatlist\"]"));
		swipeToDropDown(element3);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Studio\"]")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkin']")).click();

		driver.findElement(By.xpath("//android.view.View[@content-desc=\"23 April 2025\"]")).click();

		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='search_select_checkout']")).click();

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='No. Of Room']")).click();
		WebElement element5 = driver.findElement(
				By.xpath("//android.widget.ScrollView[@content-desc=\"search_select_no_of_rooms flatlist\"]"));
		swipeToDropDown(element5);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"4-Four\"]")).click();

		performSwipe();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"No. Of Adults\"]")).click();

		WebElement element6 = driver.findElement(
				By.xpath("//android.widget.ScrollView[@content-desc=\"search_select_no_of_adults flatlist\"]"));
		swipeToDropDown(element6);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"4-Four\"]")).click();

		WebElement e2 = driver
				.findElement(By.xpath("//android.widget.EditText[@resource-id=\"search_no_of_children\"]"));
		e2.sendKeys("2");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search']")).click();
		Thread.sleep(3000);

//		WebElement e3 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='header_welcome']"));
//		String t1 = e3.getText();
//		System.out.println(t1);
//
//		WebElement e4 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='select_hotel_text']"));
//		String t2 = e4.getText();
//		System.out.println(t2);
//		Thread.sleep(2000);
		performSwipe();

		System.out.println("Swipe performed successfully.");

		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"hotel_continue_button\"]")).click();

		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();

		
		
		
		
		By targetLocator = By.xpath("//android.widget.TextView[@text='Myself']");

		swipeToElement(targetLocator);

		driver.findElement(targetLocator).click();
		Thread.sleep(2000);
		performSwipe();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select Salutation\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Ms.\"]")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_first_name\"]"))
				.sendKeys("Monika");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_last_name\"]"))
				.sendKeys("yuvaraj");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_mobile_no\"]"))
				.sendKeys("8667847093");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_email\"]"))
				.sendKeys("monikayuvaraj145@gmail.com");

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Enter GST Details (Optional)\"]")).click();
		performSwipe();
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_registration\"]"))
				.sendKeys("9043592058");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_company_name\"]"))
				.sendKeys("Greens Tech OMR Branch");

		driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"book_hotel_company_address\"]"))
				.sendKeys("Thoraipakkam");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Next\"]")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Credit/Debit/ATM Card\"]")).click();

		performSwipe();
		Thread.sleep(6000);
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='payment_type']")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Debit Card\"]"))
				.click();

		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"card_type\"]")).click();

		driver.findElement(AppiumBy
				.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Visa\"]"))
				.click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"card_no\"]"))
				.sendKeys("5555 5555 5555 2222");

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"card_name\"]")).sendKeys("yuvaraj");

		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"card_month\"]")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"March\"]"))
				.click();

		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"card_year\"]")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"2026\"]"))
				.click();

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"cvv\"]")).sendKeys("537");

		performSwipe();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"submitBtn\"]")).click();

	}

}
