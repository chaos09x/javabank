package account;

public class checkingAccount {

	private String ownerName;
	private double balance;

	public checkingAccount(String ownerName, double balance) {
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		this.balance -= amount;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void transfer(checkingAccount destinationAccount, double amount, checkingAccount sourceAccount) {
		destinationAccount.deposit(amount);
		sourceAccount.balance -= amount;
	}
}
