package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVFIleforbankAccApp {
	
	//This function will read file and project it in a table format as list.Lec-37
	public static List<String[]> read(String file) //static is used so we can use file at any time.
	{
		//Collection are data structure that allows you to add elements dynamically
		List<String[]> data = new LinkedList<String[]>();//LinkedList
		
		String dataRow;
		try {
			
			//Way to parse data
			BufferedReader br = new BufferedReader(new FileReader(file));//to open reader to open the file
			
			//String dataRow = br.readLine();//to read each line 
			//Instead of above line we declared the dataRow up to make sure it reads for multiple lines in one 
			//go
			//In order to all the lines we declare dataRecords outside followed by following command
			while((dataRow = br.readLine()) != null){ //we are setting dataRow = readline so it reads till the 
													 //end of the file.Then execute two lines as given:
			String[] dataRecords = dataRow.split(","); //Splitting each record with comma and put that into 
													  //an array.
			data.add(dataRecords);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not Find File.");
			e.printStackTrace();
		
		} catch (IOException e) {
			System.out.println("COuld not Read File.");
			e.printStackTrace();
		}
		
		
		return data;
		
	}

}
