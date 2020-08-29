package bankAccountApp;

//This is your superclass.Whatever you write in it is there for both Savings and Checking Account
//We are going to make Account as an abstract becoz we r not gonna make objects from this
//account that is gonna happen in savings account and checking account.

/*In Lec 36 We are going to use access modifiers to hide the data as required like protected to make sure that
 * the data we want to hide can be accessed by its base classes i.e CheckingAccount and SavingsAccount and soon.
*/

public abstract class Account implements IBaseRate {
	// List common properties for current and savings account
	private String name;//Private added in lec-36 
	private String socSecNo;//Private added in lec-36 
	private double balance;//Private added in lec-36 
	
	protected String accNumber;// to make them accessible to CA & SA but not to any other classes.
	protected double rate;//Proteced added in lec-36 
	
	// Lec28
	private static int index = 10000;//Private added in lec-36 

	// Constructor to set base properties and initialize the account
	public Account(String name, String socSecNo, double initdeposit) {//int to double
		// 1-PartSystem.out.print("New Account ");
		this.name = name;
		this.socSecNo = socSecNo;
		this.balance = initdeposit;

		  // Lect-30
		 // System.out.println("Name:"+name+" social Security Number:"+socSecNo+" Bal:$"+initdeposit);
		// Set account number
		index++;
		this.accNumber = setAccountNumber();
					   // After Lec 29 Not needed below line
					  // System.out.println("Account Number(10-digit):" +this.accNumber);
		setRate();   // Lect-33 to print our functions from SA & CA with same name
					// originate from here.Otherwise nthin will print
	}

	// Lect-33 Setting Up interest Rate and implementation
	public abstract void setRate(); // This is an abstract method Abstract class is above.
				// Why? Because we cannot create an object in abstract class which this really is.So,we are
			   // Just creating an Architecture here for the subclasses(SA & CA) to succeed
			  // further on as
			 // their requirements.We are simply forcing our subclasses to implement the
			// setRate method.
		   // Look at Line 66.

	// Lec-34 List common methods-Interaction with savings account
	public void deposit(double amount) {
		balance = balance + amount;
		printBalance();
	}

	public void withdraw(double amount) {
		balance = balance - amount;
		printBalance();
	}

	public void transfer(String destination, double amount) {
		balance = balance - amount;
		printBalance();
	}

	public void printBalance() {
		System.out.println("Your remaining balance is:$" + balance);

	}
	//Till here
	
	//Lec-35 Calculating Compound Interest
	public void accuredCompoundInterest() {
		double accuredComInt = balance*(rate/100);
		balance = balance + accuredComInt;
		System.out.println("The Compound Interest is:$"+accuredComInt);
		printBalance();
	}

	// Lec-28 Creating 11 -digit Account Number from several conditions:
	private String setAccountNumber() {
		String last2OfSSN = socSecNo.substring(socSecNo.length() - 2,socSecNo.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));// making a
																	// random 3
																	// digitnumber
		return last2OfSSN + uniqueID + randomNumber;

	}

	// Lec-30
	public void showInfo() {
		System.out.println("Name:" + name + "\nAccount No: " + accNumber
				+ "\nBalance: " + balance + "\nRate: " + rate + "%");
	}
}
