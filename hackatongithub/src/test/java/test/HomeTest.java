package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

/**
 * @author anderson.mann
 *
 */
import org.testng.annotations.Test;

import core.BaseTest;
import page.HomePage;
import page.OrderPage;

public class HomeTest extends BaseTest {
	private HomePage home = new HomePage();

	@Test
	public void pwaOn() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		assertEquals("https://forza-pwa.herokuapp.com/", driver.getCurrentUrl());
	}

	@Test
	public void readOrder() throws Exception {
		home.openFAQ();
	}

	@Test
	public void swipe() throws Exception {
		home.swipeLeft();
	}

	@Test
	public void order() throws Exception {
		home.clickReadOrderButton();
	}

}
