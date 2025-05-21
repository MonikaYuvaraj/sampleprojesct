package omrHotelBooking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class BaseClassMob {

	public static WebDriver driver;

	public static void launchApp(String platformName, String deviceName, String appPackage, String appActivity,
			String automationName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName", deviceName);
		capabilities.setCapability("appium:platformName", platformName);
		capabilities.setCapability("appium:appPackage", appPackage);
		capabilities.setCapability("appium:appActivity", appActivity);
		capabilities.setCapability("appium:automationName", automationName);

		driver = new AppiumDriver(capabilities);

	}

	public static void elementSendKeys(By by, String data) {
		WebElement element = findElement(by);
		element.sendKeys(data);
	}

	public static void elementClick(By by) {
		WebElement element = findElement(by);
		element.click();
	}

	public static void performSwipe() {
		int centerX = findCenterX();
		int startY = findStartY();
		int endY = findEndY();

		// 1. Create the Object for PointerInput Class
		PointerInput pointerInput = new PointerInput(Kind.TOUCH, "finger1");

		// 2. Create tehe Object for sequence Class
		Sequence sequence = new Sequence(pointerInput, 1);

		// 1. Move to start position
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), centerX, startY));

		// 2. Down-->Press
		sequence.addAction(pointerInput.createPointerDown(MouseButton.LEFT.asArg()));

		// 3. Move to end position
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), centerX, endY));

		// 4. Up--->Release
		sequence.addAction(pointerInput.createPointerUp(MouseButton.LEFT.asArg()));

		List<Sequence> asList = Arrays.asList(sequence);

		// perform--->RemoteWebDriver Classs
		RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
		remoteWebDriver.perform(asList);

	}


	public static void swipeToElement(By by) {
		List<WebElement> elements = findElements(by);
		while (elements.size() == 0) {
			performSwipe();
			elements = findElements(by);

		}

	}

	public static void swipeToDropDown(WebElement element) {

		Rectangle rect = element.getRect();
		int centerX = rect.getX() + rect.getWidth() / 2;
		int startY = rect.getY() + (int) (rect.getHeight() * 0.8);
		int endY = rect.getY() + (int) (rect.getHeight() * 0.2);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX, endY));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		List<Sequence> asList = Arrays.asList(swipe);
		RemoteWebDriver rw = (RemoteWebDriver) driver;
		rw.perform(asList);
	}

	public static WebElement findElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public static List<WebElement> findElements(By by) {
		List<WebElement> elements = driver.findElements(by);
		return elements;
	}

	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		System.out.println(value);
		return value;
	}

	public static Dimension getDimension() {
		Dimension size = driver.manage().window().getSize();
		return size;

	}

	public static int findCenterX() {
		int centerX = getDimension().getWidth() / 2;
		return centerX;

	}

	public static int findStartY() {
		int startY = (int) (getDimension().getHeight() * 0.80);
		return startY;

	}

	public static int findEndY() {
		int endY = (int) (getDimension().getHeight() * 0.20);
		return endY;

	}

	
}
