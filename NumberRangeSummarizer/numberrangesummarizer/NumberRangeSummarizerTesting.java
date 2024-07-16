package numberrangesummarizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * @author Dylan Raw
 * 
 * This class implements and tests the NumberRangeSummarizer class
 * 
 * This has both an Automatic test and a Manual test. Inputs are made
 * in the console
 * 
 * 
 * 
 */

public class NumberRangeSummarizerTesting {

	public static void main(String[] args) throws IOException {
		NumberRangeSummarizer nrs = new NumberRangeSummarizer();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean running = true;
		while (running) {
			System.out.println("For Automatic Test enter 1. For Manual Test enter 2.");
			System.out.println("To exit enter e");
			String input = reader.readLine();
			switch (input) {
			case "1":
				for (int i=1 ; i<5;i++) {
					ArrayList<Integer> dataArray = nrs.collect(inputdata(i-1));
					String outputString = nrs.summarizeCollection(dataArray);
					System.out.printf("Input String - %s \n",inputdata(i-1));
					System.out.printf("Output String - %s \n",outputString);
					
					if (outputString.equals(outputdata(i-1))) {
						System.out.printf("Test successful for data set %d \n",i);
					}else {
						System.out.printf("Test unsuccessful for data set %d \n",i);
					}
				}
				break;
			case "2":
				System.out.println("Enter the comma seperated String below. ");
				String inputString = reader.readLine();
				ArrayList<Integer> dataArray = nrs.collect(inputString);
				String outputString = nrs.summarizeCollection(dataArray);
				System.out.printf("Input String - %s \n",inputString);
				System.out.printf("Output String - %s \n",outputString);
				
				break;
			
			case "e":
				System.out.println("System Exit");
				running = false;
				break;
			default:
				running = true;
				break;
			
			}		
		}
	}
	
	public static String inputdata(int input) {
		String[] testData = {"1,3,6,7,8,11,12,13,14,15,21,22,23,24,31","0,3,4,6,7,8,9,12,13,14,15,16,18,21,22,12,34,35,36,37",
				"2,3,6,7,8,,12,13,14,15,16,19,20,21,22,23,24,31","3,4,5,7,8,10,13,14,15,18,21,21,23,24,95,106"};
		
		return testData[input];
	}
    
	public static String outputdata(int input) {
		String[] outputValues = {"1, 3, 6-8, 11-15, 21-24, 31","0, 3-4, 6-9, 12-16, 18, 21-22, 34-37",
				"2-3, 6-8, 12-16, 19-24, 31","3-5, 7-8, 10, 13-15, 18, 21, 23-24, 95, 106"};
		
		return outputValues[input];
	}
   /* 
    public NumberRangeSummarizer(){
        ArrayList<Integer> outInt = collect("1,3,6,7,8,,12,13,14,15,21,22,23,24,31") ;
        String out = summarizeCollection(outInt);
        System.out.println(out);
    }
    */
}
