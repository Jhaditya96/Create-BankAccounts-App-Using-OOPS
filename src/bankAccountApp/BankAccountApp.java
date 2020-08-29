package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		
		//Lec-39
		List<Account> account = new LinkedList<Account>(); //Here we have data structure of two for these
		//objects  ()->empty constructor
		
		
			
		/* After Lec 37 we are using CSV file from utilities to read file and take elements so as for further 
		 * process.
		CheckingAccount chkacc1 = new CheckingAccount("John Cena", "123456789", 25000);

		SavingsAccount savacc1 = new SavingsAccount("Under Taker", "987654321", 30000);

		// Lec-30 After removing all sysout operations
		chkacc1.showInfo();
		System.out.println("-------------------------------------------------------------------------");
		savacc1.showInfo();
		
		//Lec-34
		//savacc1.deposit(5000);
		//savacc1.withdraw(200);
		//savacc1.transfer("Stockholm", 1000);

		//Lec-35
		savacc1.accuredCompoundInterest();
		*/
	
		
		// Read a .csv file and create accounts based on that data. LEC-37
		//Accessing the file using URL from specific local location.
		String file = "G:\\Java Apr_2020\\Luna WorkSpace\\ProjectTarget.csv";
		
		
		List<String[]> newAccountHolders = utilities.CSVFIleforbankAccApp.read(file);//This data structure has
		//our data from the file.
		
		for(String[] accountHolder : newAccountHolders){//Reading all the data in the file at once dynamically
		  /*In last Lec-37 we took all the data from our csv file and printed the whole file.
		   
		   * System.out.println("NEW ACCOUNTS:");
			System.out.println(accountHolder[0]);
			System.out.println(accountHolder[1]);
			System.out.println(accountHolder[2]);
			System.out.println(accountHolder[3]);*/
		
			
			//Lec - 38
			//Determining here which new account to open
			//System.out.println("NEW ACCOUNTS:");
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			
			
			//System.out.println(name+" "+sSN+" "+accountType+"$"+initDeposit);
			
			
			if(accountType.equals("Savings")){
				//System.out.println("OPEN A SAVINGS ACCOUNT");//Lec-38
				account.add(new SavingsAccount(name,sSN,initDeposit));
			}
			else if(accountType.equals("Checking")){
				//System.out.println("OPEN A CHECKING ACCOUNT");//Lec-38
				account.add(new CheckingAccount(name,sSN,initDeposit));
			}
			else{
				System.out.println("Invalid Account.");//Lec-38
			}
		}
		//Before iterating through the whole file Lets just access one specific file
		//account.get(5).showInfo();
		//Lec-39 Now we want to iterate through the whole file.
		for(Account acc : account){//iterate through the whole file without interruption
			acc.showInfo();
		}
	}
}

