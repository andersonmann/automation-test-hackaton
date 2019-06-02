/**
 * 
 */
package test;

import org.testng.annotations.Test;

import core.BaseTest;
import page.HomePage;
import page.OrderPage;

/**
 * @author anderson.mann
 *
 */
public class OrderTest extends BaseTest {
	private HomePage home = new HomePage();
	private OrderPage order = new OrderPage();

	@Test
	public void digitaNumeroComanda() {
		order.typeOrderNumber("51");
	}

}
