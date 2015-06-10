/**
*Author: Ryan Samarajeewa 
*Description: A Java implementation of a random 
*hex color generator. To be used for reference when 
*building an Android app that performs the same function.
*/
import java.lang.*;
import java.math.*;
import java.util.Random;

public class RandColorGenerator {
	
	//main() to generate a single color in hex form 
	public static void main(String[]args){
			System.out.println("Random color in hex: #"+genValue()+genValue()+genValue());//print a random hex color 
	}
	
	/**
	*Generates a string of two characters that 
	*correspont to a hexadecimal value from 00 to FF 
	*Three of these strings represent 
	*a color combining red, green, and blue (RGB).
	*@return a hex value from 00 to FF
	*/
	private static String genValue(){
		String[] letters = {"A", "B", "C", "D", "E", "F"};//array of letters for hexadecimal value
		
		boolean digitZero = getRandomBoolean();//if true, the 0th digit of the hex number is a letter (A to F), and a number (0-9) if false
		boolean digitOne = getRandomBoolean();//if true, the 1st digit of the hex number is a letter (A to F), and a number (0-9) if false
		
		String toReturn;//String object to be returned 
		
		//determine if the 0th digit is a letter or a number 
		if(digitOne){
			toReturn = letters[(int)(Math.random()*5)];
		}else{
			toReturn = Integer.toString((int)(Math.random()*9));
		}
		
		//determine if the 1st digit is a letter or a number 
		if(digitZero){
			toReturn = toReturn + letters[(int)(Math.random()*5)];
		}else{
			toReturn = toReturn + Integer.toString((int)(Math.random()*9));
		}
		
		return toReturn;
	}
	
	/**
	*Generates a random boolean value.
	*@return a random boolean (true or false)
	*/
	private static boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
}