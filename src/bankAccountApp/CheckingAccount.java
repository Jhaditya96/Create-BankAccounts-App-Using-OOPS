package bankAccountApp;

public class CheckingAccount extends Account {

	// List properties specific to a Checking account
	private int debitcardNumber;//Private added in lec-36 
	private int debitcardPIN;//Access Modifier

	// Constructor to initialize checking account properties
	public CheckingAccount(String name, String socSecNo, double initDeposit) {//int to double initDeposit
		super(name, socSecNo, initDeposit);
		// As account is taking a name so we need to pass the name to that
		// constructor
		// i.e saving and checking.
		// As goes without saying that we have account number from Account class
		// in both Checking
		// as well as savings account so we can add out 11th digit to it
		// directly.Lec-29
		accNumber = "2" + accNumber;
		// Lec-30 System.out.println("Account Number(11-digit):"+accNumber);
		// Lec-30 System.out.println("New Checking Account");
		// This is second becoz any super must be first thing defined in an
		// constructor.If there
		// is a super.
		// 1-part.System.out.println("Name is:"+name);
		// Lect-32
		setDebitCard();
	}

	// Lec-33
	@Override
	public void setRate() {
		rate = getBaseRate() * .15; // Output is getting printed in Accounts as
									// rate is from there.
	}

	// List any methods specific to the checking account
	// Lect-32
	private void setDebitCard() {
		debitcardNumber = (int) (Math.random() * Math.pow(10, 3));
		debitcardPIN = (int) (Math.random() * Math.pow(10, 4));
	}

	// If we do that it will override the showInfo in account class.
	// To make sure that don`t happen we will add the super.showInfo() method to
	// make sure that
	// the override don`t happen and we can write our method specific for this
	// class as well,,,
	public void showInfo() {
		super.showInfo();
		System.out.println("********");
		System.out
				.println("Specific details from checking account!! Account Type: Checking Accnt");
		System.out.println("********");

		// Lect-32
		System.out.println("Your Checking Account Details(Lect-32)"
				+ "\n Card Number is:" + debitcardNumber + "\n Card PIN is:"
				+ debitcardPIN);
	}

}