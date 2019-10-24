package brianRobinson;

import java.util.*;

final class Module3 {

	// ***********************************************
	Module3() { // Constructor
		LogIt.logit("Module3", "Constructor");
	}

	// ***********************************************
	public void runExersizes() {
		String label = "runExersizes";

		String str = "";
		Scanner scanner = new Scanner(System.in);
		do {
			LogIt.logit(label, "");
			LogIt.logit(label, "=================================================================");
			LogIt.logit(label, " Please chose action - (A)dd, (D)isplay, (S)earch or e(X)it. ");
			str = scanner.next().toUpperCase();

			// ------------- ADD -----------------
			if (str.charAt(0) == 'A') {
			}

		} while (str.charAt(0) != 'X');

		scanner.close();

	}

}

//***********************************************
//***********************************************
final class SBAccount extends Account {

	final static double minBalance = 100.00;

	protected SBAccount() { // Constructor
		LogIt.logit("SBAccount", "Constructor");
	}

	protected boolean addMonthlyInterest(String r) {
		double rate = Double.parseDouble(r);
		if( rate <= 0 || getAmount() <= 0 )
			return false;
		double interest = (getAmount() * (rate / 100)) ;
		setAmount(getAmount() + interest);
		return true;
	}

	// ***********************************************
	protected boolean deposit(double d) {  	// ----- Overriding --------
		LogIt.logit("CurrentAccount", "deposit:"+d);
		if (d <= 0 || (getAmount() + d) < SBAccount.minBalance)
			return false;
		setAmount(getAmount() + d);
		return true;
	}

	protected double withdraw(double d) { 	// ----- Overriding --------
		LogIt.logit("CurrentAccount", "withdraw:"+d);
		if (getAmount() < (d - SBAccount.minBalance) ) 
			return -1;
		setAmount(getAmount() - d);
		return d;
	}
}

//***********************************************
//***********************************************
final class CurrentAccount extends Account {

	final static double minBalance = 200;

	protected CurrentAccount() { // Constructor
		LogIt.logit("CurrentAccount", "Constructor");
	}

	protected boolean addMonthlyInterest(String rate) {
		return true;
	}
	// ***********************************************
	protected boolean deposit(double d) {  	// ----- Overriding --------
		LogIt.logit("CurrentAccount", "deposit:"+d);
		if (d <= 0 || (getAmount() + d) < CurrentAccount.minBalance)
			return false;
		setAmount(getAmount() + d);
		return true;
	}

	protected double withdraw(double d) { 	// ----- Overriding --------
		LogIt.logit("CurrentAccount", "withdraw:"+d);
		if (getAmount() < (d - CurrentAccount.minBalance) ) 
			return -1;
		setAmount(getAmount() - d);
		return d;
	}
}

//***********************************************
//***********************************************
abstract class Account {
	private int number = 0;
	private String name = "";
	private double amount = 0.0;

	// ***********************************************
	protected Account() { // Constructor
		LogIt.logit("Account", "Constructor");
	}

	// ***********************************************
	protected abstract boolean addMonthlyInterest(String rate); // ------ abstract method --------

	protected boolean deposit(double d) {
		LogIt.logit("Account", "deposit");
		if (d <= 0)
			return false;
		setAmount(getAmount() + d);
		return true;
	}

	protected double withdraw(double d) {
		LogIt.logit("Account", "withdraw");
		if (getAmount() >= d) {
			setAmount(getAmount() - d);
			return getAmount();
		} else
			return -1;
	}

	// ***********************************************
	protected int getNumber() {
		return number;
	}

	protected void setNumber(int number) {
		this.number = number;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected double getAmount() {
		return amount;
	}

	protected void setAmount(double amount) {
		this.amount = amount;
	}

}
