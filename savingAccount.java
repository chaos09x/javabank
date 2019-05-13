package account;
import java.text.DecimalFormat;
public class savingAccount {

	private String ownerName;
	private double balance, rate;

	public savingAccount(String ownerName, double balance, double rate) {
		this.ownerName = ownerName;
		this.balance = balance;
		this.rate = rate;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	public void TransferSave2Save(savingAccount destinationAccount, double amount, savingAccount sourceAccount) {
		if (amount > sourceAccount.balance) {
			throw new IllegalArgumentException("Source account too low");
		}
		else {
			destinationAccount.deposit(amount);
			sourceAccount.balance -= amount;
		}
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public void Interest(double years) {
		// P1 = P(1+(r/n)^nt where P1 = the new principal sum
        // P = the original payment, r = the nominal annual interest rate
        // n = the compounding frequency, t = the overall length of time(usually in years)
        double P = this.balance; // user investment + current bal.
        double r = this.rate; // personalized rate for account
        double n = 1; // this will only compound once per year
        double t = years; // this is determined by the number of years the account is open
        double P1 = P * Math.pow((1 + (r / n)), (n * t));
        DecimalFormat dfy = new DecimalFormat("#");
        double gain = P1 - P;
        this.balance += gain;
        System.out.format("Interest Gained for " + this.ownerName + " over " +
            dfy.format(years) + " years " + "$%.2f\r\n", gain);
	}
}
