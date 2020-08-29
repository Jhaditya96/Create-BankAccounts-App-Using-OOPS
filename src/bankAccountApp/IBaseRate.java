package bankAccountApp;

public interface IBaseRate {

	//This is pre written interface which a bank gets from the RBI or monetary body which 
		//decides the interest rates and other form of interests which happened to be given by them
		//So we are only writing as someone else.Remember...
		//As we have two different conditions for both checking and savings accounts i.e SA 25% of BR	 
		// and for CA 15% of BR.We both know that the Accounts class wouldn`t know the difference
		//so what we gonna do is we gonna create a public abstract class named `setRate() method`
		//which we are doing to implement the setRate() in both of these classes(CA & SA) to
		//make sure that they calculate the setRate as per their requirements.  
			
		//Write a method that returns the base Rate
		
	    default double getBaseRate()
	    {
	    	return 2.5;
	    }
}
