/**
 * 
 */
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import core.BasePage;
import core.DataGenerator;

/**
 * @author anderson.mann
 *
 */
public class PaymentPage extends BasePage {
	private DataGenerator dataGenerator = new DataGenerator();
	private final String creditCard = "portal-checkout-credit-debit";
	private final String creditCardAndBillet = "portal-checkout-credit-debit-billet";

	public void creditCard(String card, int paymentInstallments) {
		if (isElementPresent(By.id(creditCard)) == true) {
			log.getTest().log(Status.INFO, "selecting the option credit card");
			click(By.id(creditCard));
		} else if (isElementPresent(By.id(creditCardAndBillet)) == true) {
			log.getTest().log(Status.INFO, "selecting the option credit card and billet");
			click(By.id(creditCardAndBillet));
		}
		log.getTest().log(Status.INFO, "selecting the credit card");
		click(By.id(card));
		paymentInstallments(paymentInstallments);
	}

	/**
	 * @param paymentInstallments
	 */
	private void paymentInstallments(int paymentInstallments) {
		if (paymentInstallments == 1) {
			log.getTest().log(Status.INFO, "selecting the quantity: 1");
			click(By.id("parcela_1"));
		}
		if (paymentInstallments == 2) {
			log.getTest().log(Status.INFO, "selecting the quantity: 2");
			click(By.id("parcela_2"));
		}
		if (paymentInstallments == 3) {
			log.getTest().log(Status.INFO, "selecting the quantity: 3");
			click(By.id("parcela_3"));
		}
		if (paymentInstallments == 4) {
			log.getTest().log(Status.INFO, "selecting the quantity: 4");
			click(By.id("parcela_4"));
		}
	}

	/**
	 * This method create all the data needed for a new credit card
	 */
	private void createCardInfos() {
		enterFrame("iframe4all");
		click(By.id("pan"));
		write(By.id("pan"), dataGenerator.creatCreditCard());
		write(By.id("holderName"), "ANDERSON M MANN");
		write(By.id("cvc"), "666");
		write(By.id("expiration"), "0621");
		exitFrame();
	}

	/**
	 * This method access the user account
	 */
	public void accessUserAccount() {
		log.getTest().log(Status.INFO, "clicking at the button account");
		click(By.id("portal-header-user"));
		log.getTest().log(Status.INFO, "clicking at the button perfil");
		click(By.xpath("//ul[@class='usuario-opcoes layer dismissible']//a[@id='portal-header-user-profile']"));
	}

	public void addCardPurchase() {
		click(By.id("portal-checkout-credit-debit"));
		click(By.xpath("//a[@class='button add-cartao']"));
		createCardInfos();
		click(By.xpath("//input[@value='Adicionar']"));
	}

	public void addCardHome() {
		accessUserAccount();
		click(By.xpath("//a[contains(text(),'Dados de pagamento')]"));
		createCardInfos();
		click(By.id("btnAdicionar"));
	}

	public void removeCardHome() {
		accessUserAccount();
		click(By.xpath("//a[contains(text(),'Dados de pagamento')]"));
		if (isElementPresent(By.id("excluir-cartao")) == true) {
			log.getTest().log(Status.INFO, "clicking at the button remove credit card");
			click(By.id("excluir-cartao"));
			log.getTest().log(Status.INFO, "clicking at the confirmation button");
			stop(1000);
			click(By.id("confirma-exclusao"));
		}
	}

	/**
	 * Find an element and click
	 * 
	 * @param By  Type of locator used for search (Ex: id, name, xpath,cssSelector)
	 * @param the locator identifier
	 * @throws NoSuchElementException
	 */
	@Override
	public void click(By by) throws NoSuchElementException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.findElement(by).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Element not found: " + e.getMessage());
		}
	}
}