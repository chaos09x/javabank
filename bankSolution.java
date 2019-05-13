package bank;
import java.util.Scanner; // user input
import account.checkingAccount; // call account package & class
import account.savingAccount; // call account package & class
public class bankSolution {

	public static void main(String[] args) {
		System.out.println("Welcome to First National Bank of Wood!");
		System.out.println();

		checkingAccount icemansAccount = new checkingAccount("Ice Man", 5000);
		checkingAccount shadowcatsAccount = new checkingAccount("Shadow Cat", 2000);

		System.out.println("Open Checking Accounts:");
		System.out.println();
		printAccountDetails(icemansAccount);
		System.out.println();
		printAccountDetails(shadowcatsAccount);

		System.out.println();
		System.out.println("Making transfer of $1000...");
		try {
			Thread.sleep(500); // allow system pausing / processing speed
		} catch (InterruptedException e) {
			return; // check if pause was interrupted
		}

		icemansAccount.transfer(shadowcatsAccount, 1000, icemansAccount);

		System.out.println("\nUpdated Account Details:");
		System.out.println();
		printAccountDetails(icemansAccount);
		System.out.println();
		printAccountDetails(shadowcatsAccount);

		// Initialize new savings account with initial balance of $30,000 and 0.89% interest
		savingAccount gambitsSavingAccount = new savingAccount("Gambit", 30000, .0089);
		// Initialize new savings account with initial balance of $10,000 and .56% interest
		savingAccount roguesSavingAccount = new savingAccount("Rogue", 10000, .0056);
		
		System.out.println("\nOpen Saving Accounts:");
		System.out.println();
		printAccountDetails2(gambitsSavingAccount);
		System.out.println();
		printAccountDetails2(roguesSavingAccount);
		
		gambitsSavingAccount.TransferSave2Save(roguesSavingAccount, 5000, gambitsSavingAccount);
		System.out.println("\nMaking transfer of $5000.00...");
		try {
			Thread.sleep(500); // allow system pausing / processing speed
		} catch (InterruptedException e) {
			return; // check if pause was interrupted
		}
		System.out.println("\nUpdated Account Details\n");
		printAccountDetails2(gambitsSavingAccount);
		System.out.println();
		printAccountDetails2(roguesSavingAccount);
		System.out.println();
		Scanner input = new Scanner(System.in); // demonstrates user input
		System.out.println("Please enter years for interest accumulation >> ");
		int firstNum = input.nextInt();
		
		// apply 2 years of interest to the savings accounts
		gambitsSavingAccount.Interest(firstNum);
		System.out.println("\n");
		roguesSavingAccount.Interest(2);
		
		System.out.println("\nUpdated Account Details\n");
		printAccountDetails2(gambitsSavingAccount);
		System.out.println();
		printAccountDetails2(roguesSavingAccount);
		System.out.println();
		if(input !=null)
	        input.close();
	}

	private static void printAccountDetails(checkingAccount account) { // method to print account balances
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
	}
	private static void printAccountDetails2(savingAccount account) { // method to print account balances
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
	}
}
