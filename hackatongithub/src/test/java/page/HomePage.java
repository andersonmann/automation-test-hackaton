/**
 * 
 */
package page;

import org.openqa.selenium.By;

import core.BasePage;

/**
 * @author anderson.mann
 *
 */
public class HomePage extends BasePage {

	public void openFAQ() {
		click(By.id("openFAQBtn"));
	}

	public void clickReadOrderButton() {
		click(By.id("LerCartaoBtn"));
	}

	public void myCards() {
		click(By.id("MeusCartoesBtn"));
	}

	public void accessAccount() {
		click(By.id("MinhaContaBtn"));
	}

	public void swipeLeft() throws Exception {
		swipe(250, 600, 60, 600);
	}
}