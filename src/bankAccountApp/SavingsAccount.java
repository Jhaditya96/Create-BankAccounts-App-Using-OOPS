package bankAccountApp;

public class SavingsAccount extends Account {

	// List the properties specific to the savings account
	private int safetyDepositBoxID;//Private added in lec-36 
	private int safetyDepositBoxKey;//Private added in lec-36 

	// Constructor to initialize the setting for Savings account
	public SavingsAccount(String name, String socSecNo, double initdeposit) {//int to double
		super(name, socSecNo, initdeposit);// As we have called a constructor in
											// out super class
		// i.e. Account we have to define it in saving and checking class as
		// well as both extends
		// Account class

		// As goes without saying that we have account number from Account class
		// in both Checking
		// as well as savings account so we can add out 11th digit to it
		// directly.Lec-29
		accNumber = "1" + accNumber;
		// Lec-30 System.out.println("Account Number(11-digit):"+accNumber);
		// Lec-30 System.out.println("New Savings Account");
		// 1-part.System.out.println("Name is:"+name);

		// Lec-31
		setSafetyDepositBox();
	}

	// Lect-33
	@Override
	public void setRate() {
		rate = getBaseRate() * .25;

	}

	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));// Create a
																		// 3-digit
																		// ID
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));

	}

	// List any methods specific to savings account
	// Lec-30 If we do that it will override the showInfo in account class.
	// To make sure that don`t happen we will add the super.showInfo() method to
	// make sure
	// that the override don`t happen and we can write our method specific for
	// this class as well,,
	public void showInfo() {
		super.showInfo();
		System.out.println("********");
		System.out.println("Specific details from SavingsAccount!! Account "
				+ "Type:Savings Account");
		System.out.println("********");
		System.out.println("Your savings account Features:(From Savings Class)"
				+ "\n Safety Deposit Box ID:" + safetyDepositBoxID
				+ "\n Safety Deposit Box Key: " + safetyDepositBoxKey);
	}

}
