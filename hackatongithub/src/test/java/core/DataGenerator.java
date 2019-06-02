/**
 * 
 */
package core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * @author anderson.mann
 *
 */
public class DataGenerator {

	public String createEmailAddress() {
		return "test" + String.valueOf(Math.random() * 101) + "@4all.com";
	}

	public String createPhoneNumber() {
		String phoneNumber = "";

		for (int i = 0; i < 8; i++) {
			int j = (int) (Math.random() * 10);
			phoneNumber += String.valueOf(j);
		}
		return "55509" + phoneNumber;
	}

	public String createCPF() {
		ArrayList<Integer> cpf = new ArrayList<Integer>();

		for (int i = 0; i < 9; i++) {
			int j = (int) (Math.random() * 10);
			cpf.add(j);
		}

		return this.convertToString(this.calcCPFVerifierDigit(cpf));
	}

	public ArrayList<Integer> calcCPFVerifierDigit(ArrayList<Integer> cpf) {
		for (int b = 0; b < 2; b++) {
			int j = cpf.size() + 1;
			int aux = 0;

			for (int i = 0; i < cpf.size(); i++) {
				aux += (cpf.get(i) * j);
				j = j - 1;
			}

			int rest = 11 - (aux % 11);

			if (rest > 9) {
				rest = 0;
			}

			cpf.add(rest);
		}

		return cpf;
	}

	public String convertToString(ArrayList<Integer> numberToConvert) {
		String newAttributte = "";

		for (Integer number : numberToConvert) {
			newAttributte += String.valueOf(number);
		}

		return newAttributte;
	}

	public String creatCreditCard() {
		ArrayList<Integer> cardNumber = new ArrayList<Integer>();
		ArrayList<Integer> cardNumberOriginal = new ArrayList<Integer>();
		int aux = 0;

		cardNumber.add(4);
		cardNumber.add(7);
		cardNumber.add(1);
		cardNumber.add(6);
		cardNumber.add(9);
		cardNumber.add(9);

		for (int i = 0; i < 9; i++) {
			int j = (int) (Math.random() * 10);
			cardNumber.add(j);
		}
		for (Integer number : cardNumber) {
			cardNumberOriginal.add(number);
		}

		Collections.reverse(cardNumber);
		for (int j = 0; j < 15; j = j + 2) {
			cardNumber.set(j, cardNumber.get(j) * 2);
			if (cardNumber.get(j) > 9) {
				cardNumber.set(j, cardNumber.get(j) - 9);
			}
		}
		for (int k = 0; k < cardNumber.size(); k++) {
			aux = aux + cardNumber.get(k);
		}

		int lastDigit = (aux * 9) % 10;
		cardNumberOriginal.add(lastDigit);
		return this.convertToString(cardNumberOriginal);
	}

	public String expirationDateCC() {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR) + 3;

		return "0" + String.valueOf(month) + String.valueOf(year).replaceFirst("20", "");
	}

}
