package page;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import core.BasePage;

/**
 * @author anderson.mann
 *
 */
public class LoginPage extends BasePage {

	/**
	 * Method that logs in through the home page
	 * 
	 * @param user
	 * @param password
	 */
	public void loginHome(String user, String password) {
		log.getTest().log(Status.INFO, "clicking at the enter button");
		click(By.id("portal-header-user-signin"));
		login(user, password);
	}

	/**
	 * Method that logs in to the system
	 * 
	 * @param user
	 * @param password
	 */
	public void login(String user, String password) {
		log.getTest().log(Status.INFO, "Login: filling the phone or e-mail field");
		write(By.xpath("//input[@placeholder='E-mail ou Telefone']"), user);
		log.getTest().log(Status.INFO, "Login: filling the password field");
		write(By.xpath("//input[@placeholder='Senha']"), password);
		log.getTest().log(Status.INFO, "clicking at the continue button");
		click(By.xpath("//button[contains(text(),'Continuar')]"));
		stop(5000);
	}

}
