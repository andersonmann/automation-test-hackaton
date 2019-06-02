/**
 * 
 */
package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author anderson.mann
 *
 */
public class DriverFactory {
	protected static WebDriver driver;
	private static final String url = "https://forza-pwa.herokuapp.com/";

	/**
	 * @param platform
	 * @param device
	 */
	@BeforeMethod
	@Parameters({ "platform", "device" })
	public void launchSimulator(String platform, String device) {
		if (platform.equalsIgnoreCase("simulator")) {
			setupSimulator(device);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		try {
			driver.get(url);
		} catch (TimeoutException e) {
			System.out.println("Page: " + url + " did not load within 10 seconds!");
			e.printStackTrace();
		}
	}

	/**
	 * @param device
	 */
	public void setupSimulator(String device) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");

		if (device.equalsIgnoreCase("iPhone X")) {
			chromeOptions.addArguments("window-size=375x812");
		}
		if (device.equalsIgnoreCase("Galaxy S9")) {
			chromeOptions.addArguments("window-size=360x640");
		}
		if (device.equalsIgnoreCase("Pixel 2")) {
			chromeOptions.addArguments("window-size=411x731");
		}
		if (device.equalsIgnoreCase("iPhone 6")) {
			chromeOptions.addArguments("window-size=375x667");
		}
		if (device.equalsIgnoreCase("Moto Z2")) {
			chromeOptions.addArguments("window-size=375x667");
		}
		if (device.equalsIgnoreCase("Moto G7")) {
			chromeOptions.addArguments("window-size=414x736");
		}

		driver = new ChromeDriver(chromeOptions);
	}

	@AfterMethod
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}