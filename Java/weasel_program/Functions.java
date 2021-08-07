package weasel_program;

import java.util.ArrayList;
import java.util.Random;


/**
 * This Class has the functions used in
 * the Weasel_program.java
 * @author jonatas
 *
 */
public class Functions {
	
	/**
	 * Draw a character 
	 * @return A character from [A-Z] or a space 
	 */
	public char draw_accepted_char() {
		Random random = new Random();
		int char_asc = random.nextInt(27) + 64;
		if ((char_asc >= 65) && (char_asc <= 90)) {
			return (char) char_asc;
		}
		else {
			return ' ';
		}
		
	}
	
	/**
	 * Generates a random string
	 * @param size String size
	 * @return A random string
	 */
	public String random_string(int size) {
		
		String string = new String();
		string = "";
		for (int i = 0; i < size; i++)
			string += Character.toString(draw_accepted_char());
		
		return string;
	}
	
	/**
	 * Generates an ArrayList of copies of a string
	 * @param string
	 * @param number_of_copies
	 * @return The ArrayList with the string copies
	 */
	public ArrayList<String> matrix_string_copies(String string, int number_of_copies){
		
		ArrayList<String> string_copies = new ArrayList<String>();
		for (int i = 0; i < number_of_copies; i++)
			string_copies.add(string);
		
		return string_copies;
		
	}
	
	/**
	 * Simulates a draw with 5% chance of win
	 * @return 1 if win, 0 if losses
	 */
	public static int draw_with_probality_005() {
		Random random = new Random();
		int draw = random.nextInt(20) + 1;
		if (draw == 4)
			return 1;
		else
			return 0;
	}
	
	/**
	 * Generates a new string from an existent one
	 * in which each of the characters had 5% chance of change
	 * @param string
	 * @return The new string
	 */
	public String replace_characters(String string) {
		
		String new_string = new String();
		new_string = "";
		for (int i = 0; i < string.length(); i++) {
			if (draw_with_probality_005() == 1) 
				new_string += Character.toString(draw_accepted_char());
			else
				new_string += string.substring(i, i + 1);
			
		}
		
		return new_string;
	}
	
	/**
	 * Counts how many characters are the same between two strings
	 * with the same length
	 * @param string
	 * @param target Another string
	 * @return Number of the same characters in the same positions
	 */
	public int string_points(String string, String target) {
		
		int points = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == target.charAt(i))
				points++;
		}
		
		return points;
		
	}
	
	/**
	 * Returns the more equal string to string target from an
	 * ArrayList of string
	 * @param string_copies The ArrayList
	 * @param target String target
	 * @return The more equal string to string target
	 */
	public String best_string_so_far(ArrayList<String> string_copies, String target) {
		
		String best_string = new String();
		best_string = string_copies.get(0);
		
		for (int i = 1; i < string_copies.size(); i++) {
			if (string_points(string_copies.get(i), target) >
			    	string_points(best_string, target))
				best_string = string_copies.get(i);
		}
		
		return best_string;
	}
	
	/**
	 * Check if two strings are equals
	 * @param perfect_score The strings length
	 * @param string A String 
	 * @param target A String 
	 * @return 1 if are equal, 0 if not
	 */
	public int it_is_correct(int perfect_score, String string, String target) {
		
		if (string_points(string, target) == perfect_score)
			return 1;
		else
			return 0;
	}
	
}
