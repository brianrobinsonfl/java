package brianRobinson;

import java.text.DecimalFormat;
import java.util.*;

final class Module3 {
	private Account accountList[] = new Account[100];
	private int accountIdx = 0;

	// ***********************************************
	Module3() { // Constructor
		LogIt.logit("Module3", "Constructor");
	}

	static void message(String m, String t, int nbr, String n, Double d) {
		LogIt.logit(m,
				"Type (" + t + ") Number (" + nbr + ") Name (" + n + ") Amount (" + MyUtils.formatDouble(d) + ")");
	}

	private int getAccountIdx() {
		return accountIdx;
	}

	private void setAccountList(Account a) {
		accountList[accountIdx++] = a;
	}

	private Account getAccountList(int i) {
		return accountList[i];
	}

	private void displayAccountList() {
		for (int i = 0; i < getAccountIdx(); i++) {
			DecimalFormat df2 = new DecimalFormat("###.##");
			message("display", getAccountList(i).getType(), getAccountList(i).getNumber(), getAccountList(i).getName(),
					getAccountList(i).getAmount());
		}
	}

	// ***********************************************
	public void runExersizes() {
		String label = "runExersizes";

		String str = "";
		Scanner scanner = new Scanner(System.in);
		boolean found = false;
		boolean passed = false;
		do {
			LogIt.logit(label, "");
			LogIt.logit(label, "=================================================================");
			LogIt.logit(label,
					"Choose... (C)reateAccount, (U)pdateAccount, (D)isplayAccounts (A)ddInterest or e(X)it. ");
			str = scanner.next().toUpperCase();

			switch (str.charAt(0)) {

			// ---------------------------------------------------------
			case 'U':
				LogIt.logit(label, "[" + this.getAccountIdx() + "] Update Account ...");
				if (this.getAccountIdx() == 0) {
					LogIt.logit(label, " No Records found in Account List. Please go back and (C)reate some.");
					break;
				}
				this.displayAccountList();
				LogIt.logit(label, " Please enter Number:");
				String nbr = scanner.next().toUpperCase();
				found = false;
				int record = 0;
				for (; !found && record < getAccountIdx();) {
					if (Double.parseDouble(nbr) == this.getAccountList(record).getNumber())
						found = true;
					else
						record++;
				}
				if (!found) {
					LogIt.logit(label, " FAILED - Number (" + nbr + ") was Not in the list.");
					break;
				}
				message("Record Found ", getAccountList(record).getType(), getAccountList(record).getNumber(),
						getAccountList(record).getName(), getAccountList(record).getAmount());

				LogIt.logit(label, " Please choose Action - (D)eposit or (W)ithdraw ");
				str = scanner.next().toUpperCase();

				if (str.charAt(0) == 'D') {
					LogIt.logit(label, "Deposit ...");
					LogIt.logit(label, " Please enter Amount:");
					String a = scanner.next().toUpperCase();
					if (getAccountList(record).deposit(Double.valueOf(a))) {
						message( "Deposit Complete - " , getAccountList(record).getType(),
								getAccountList(record).getNumber(), getAccountList(record).getName(),
								getAccountList(record).getAmount());
					}
				}

				if (str.charAt(0) == 'W') {
					LogIt.logit(label, "Withdraw ...");
					LogIt.logit(label, " Please enter Amount:");
					String a = scanner.next().toUpperCase();
					if (getAccountList(record).withdraw(Double.valueOf(a))) {
						message( "Withdraw Complete - " , getAccountList(record).getType(),
								getAccountList(record).getNumber(), getAccountList(record).getName(),
								getAccountList(record).getAmount());
					}
				}

				if (str.charAt(0) == 'W') {
					LogIt.logit(label, "Withdraw ...");
				}

				break;
			// ---------------------------------------------------------
			case 'C':
				LogIt.logit(label, " Create Account ...");
				LogIt.logit(label, " Please enter Name:");
				String n = scanner.next().toUpperCase();
				LogIt.logit(label, " Please enter Amount:");
				String a = scanner.next().toUpperCase();
				LogIt.logit(label, " Please choose Type - (C)hecking, (S)avings ");
				str = scanner.next().toUpperCase();

				if (str.charAt(0) == 'C') {
					LogIt.logit(label, "Checking Account ...");
					CurrentAccount act = new CurrentAccount(this.getAccountIdx());
					act.setName(n);
					if (act.deposit(Double.valueOf(a))) {
						this.setAccountList(act);
						message(" Successful - ", act.getType(), act.getNumber(), act.getName(), act.getAmount());
					}
				}

				if (str.charAt(0) == 'S') {
					LogIt.logit(label, "Savings Account ...");
					SBAccount act = new SBAccount(this.getAccountIdx());
					act.setName(n);
					if (act.deposit(Double.valueOf(a))) {
						this.setAccountList(act);
						message(" Successful - ", act.getType(), act.getNumber(), act.getName(), act.getAmount());
					}
				}
				break;

			// ---------------------------------------------------------
			case 'A':
				LogIt.logit(label, " Add Interest ...");
				for (int i = 0; i < getAccountIdx(); i++)
					this.getAccountList(i).addMonthlyInterest();

				break;

			// ---------------------------------------------------------
			case 'D':
				this.displayAccountList();
				break;
			}

		} while (str.charAt(0) != 'X');
		scanner.close();

	}

}

// *******************************************************************************************
// *******************************************************************************************
final class SBAccount extends Account {

	final static double minBalance = 100.00;

	SBAccount(int n) { // Constructor
		LogIt.logit("SBAccount", "Constructor");
		setType("Savings");
		setNumber(n);
	}

	boolean addMonthlyInterest() {
		double rate = 0.04;
		if (getAmount() <= 0)
			return false;
		double interest = (getAmount() * (rate / 100));
		setAmount(getAmount() + interest);
		LogIt.logit("CurrentAccount", "addMonthlyInterest " + getNumber() + ", " + getType() + ", " + getName() + ", "
				+ MyUtils.formatDouble(getAmount()));
		LogIt.logit("CurrentAccount", "addMonthlyInterest rate(" + rate + ") currentBalance("
				+ MyUtils.formatDouble(getAmount()) + ") interest(" + MyUtils.formatDouble(interest) + ")");
		return true;
	}

	boolean deposit(double d) { // ----- Overriding --------
		LogIt.logit("CurrentAccount", "deposit " + d);
		if (d <= 0 || (getAmount() + d) < SBAccount.minBalance) {
			LogIt.logit("SBAccount",
					"deposit FAILED (" + d + ")  is less than Minimum Amount of (" + SBAccount.minBalance + ")");
			return false;
		}
		setAmount(getAmount() + d);
		return true;
	}

	boolean withdraw(double d) { // ----- Overriding --------
		LogIt.logit("SBAccount", "withdraw " + d);
		if (d <= 0 || (getAmount() - d) < SBAccount.minBalance) {
			LogIt.logit("CurrentAccount",
					"withdraw FAILED (" + (getAmount() - d) + ") is less than Minimum Amount of (" + SBAccount.minBalance + ")");
			return false;
		}
		setAmount(getAmount() - d);
		return true;
	}
}

// *******************************************************************************************
// *******************************************************************************************
final class CurrentAccount extends Account {

	final static double minBalance = 200;

	CurrentAccount(int n) { // Constructor
		LogIt.logit("CurrentAccount", "Constructor");
		setType("Checking");
		setNumber(n);
	}

	boolean addMonthlyInterest() {
		return true;
	}

	boolean deposit(double d) { // ----- Overriding --------
		LogIt.logit("CurrentAccount", "deposit:" + d);
		if (d <= 0 || (getAmount() + d) < CurrentAccount.minBalance) {
			LogIt.logit("CurrentAccount",
					"deposit FAILED (" + d + ") is less than Minimum Amount of (" + CurrentAccount.minBalance + ")");
			return false;
		}
		setAmount(getAmount() + d);
		return true;
	}

	boolean withdraw(double d) { // ----- Overriding --------
		LogIt.logit("CurrentAccount", "withdraw:" + d);
		if (d <= 0 || (getAmount() - d) < CurrentAccount.minBalance) {
			LogIt.logit("CurrentAccount",
					"withdraw FAILED (" + (getAmount() - d) + ") is less than Minimum Amount of (" + CurrentAccount.minBalance + ")");
			return false;
		}
		setAmount(getAmount() - d);
		return true;
	}
}

// *******************************************************************************************
// *******************************************************************************************
abstract class Account {
	private int number = 0;
	private String name = "";
	private double amount = 0.0;
	private String type = "";

	Account() { // Constructor
		LogIt.logit("Account", "Constructor");
	}

	abstract boolean addMonthlyInterest(); // ------ abstract method --------

	boolean deposit(double d) {
		LogIt.logit("Account", "deposit");
		if (d <= 0)
			return false;
		setAmount(getAmount() + d);
		return true;
	}

	boolean withdraw(double d) {
		LogIt.logit("Account", "withdraw");
		if (getAmount() >= d)
			return false;
		setAmount(getAmount() - d);
		return true;
	}

	int getNumber() {
		return number;
	}

	void setNumber(int number) {
		this.number = number + 1000;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getAmount() {
		return amount;
	}

	void setAmount(double amount) {
		this.amount = amount;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

}
