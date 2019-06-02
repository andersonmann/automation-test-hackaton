/**
 * 
 */
package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import core.BasePage;

/**
 * @author anderson.mann
 *
 */
public class OrderPage extends BasePage {
	HomePage home = new HomePage();

	public void typeOrderNumber(String typeNumber) {
		home.clickReadOrderButton();
		click(By.id("digitarComanda"));
//		enterFrame("1");
		switchTo(1);

//		Alert promptAlert = driver.switchTo().alert();
//		String alertText = promptAlert.getText();
//		System.out.println("Alert text is: " + alertText);

		write(By.id("com.android.chrome:id/js_modal_dialog_prompt"), typeNumber);

//		promptAlert.sendKeys(typeNumber);
//		stop(2000);
//		promptAlert.accept();
//		promptAlert.dismiss();
	}

}
