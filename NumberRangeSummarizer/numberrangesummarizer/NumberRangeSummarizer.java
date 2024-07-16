package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Werner
 * 
 * Modified by: Dylan Raw
 * Date: 15/07/2024
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */

public class NumberRangeSummarizer {

    //collect the input
    public ArrayList<Integer> collect(String input){
    	
    	/*
    	 * The code below splits the input string using the ',' delimiter
    	 * This String Array is converted to an ArrayList where any
    	 * instance of blank spaces or null entries are removed.
    	 */
        String[] tempArray = input.split(",");
        ArrayList<String> stringArray = new ArrayList<>(Arrays.asList(tempArray));
        stringArray.removeAll(Arrays.asList("",null));
        
        ArrayList<Integer> intArray = new ArrayList<>();
        
        /* Converts String value to an Integer and adds this value to the ArrayList */
        for (String inputString : stringArray) {
            intArray.add(Integer.valueOf(inputString));
        }
        
        Collections.sort(intArray);		//Sorts Integer Array into ascending order
        return intArray;
    }

    //get the summarized string
    public String summarizeCollection(ArrayList<Integer> input){
    	
    	//The code below removes any duplicate values from the Array
        ArrayList<Integer> valuesArray = new ArrayList<>();
        for (int element : input) { 
            if (!valuesArray.contains(element) && !"".equals(String.valueOf(element))) { 
                valuesArray.add(element); 
            } 
        }

        int currentValue = valuesArray.get(0);				// Initializes the first Integer value in the Array
        String outputString = String.valueOf(currentValue);	// Add the first value to a new String
        valuesArray.remove(0);								// Removes the first value from the ArrayList
        boolean sequential = false;							// Initializes the sequential flag as false
        
        
        for (int i : valuesArray){
            if (i==currentValue+1){ // Checks if the numbers are sequential
                currentValue = i;	// Sets currentValue to the input value
                sequential = true;	// Sets sequential flag to true
            }else{
            	
            	/*
            	 * If the sequential flag is true the final value of that number sequence is 
            	 * added to the output string using the '-' delimiter. This value is stored in
            	 * the currentValue variable
            	 */
                if (sequential){	
                    outputString = String.join("-",outputString,String.valueOf(currentValue));
                }
                // Adds the next value to the output string using a ', '
                outputString = String.join(", ",outputString,String.valueOf(i));  
                sequential = false;	// Sets the sequential flag as false
                //System.out.println("3");
            }
            currentValue = i;	// Updates the currentValue variable to the last value added to the string
        }
        // Special case for strings ending on a sequence
        if (sequential){	
            outputString = String.join("-",outputString,String.valueOf(currentValue));
        }
        return outputString;	// Returns the completed output string
    }
}


