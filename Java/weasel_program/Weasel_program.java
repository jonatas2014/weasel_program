package weasel_program;

import java.util.*;

/**
 * Weasel program class
 * @author jonatas
 *
 */
public class Weasel_program {
	
	private int n_generation_copies;
	private String target; 
	
	/**
	 * Constructor
	 * 
	 */
	Weasel_program(int gc, String tgt){
		this.n_generation_copies = gc;
		this.target = tgt;
	}
	
	/**
	 * Returns the selected offspring quantity per generation
	 * 
	 */
	public int getNGeneration_copies() {
		return n_generation_copies;
	}

	/**
	 * Returns the target string
	 * 
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 * Return the perfect score value
	 * @return The target string length
	 */
	private int perfect_score_value() {
		return this.getTarget().length();
	}

	/**
	 * The weasel program
	 */
	public void execution() {
		
		Functions func = new Functions();
		
		String start = new String();
		start = func.random_string(this.getTarget().length());
		
		int generation = 0;
		
		ArrayList<String> copies = new ArrayList<String>();
		copies = func.matrix_string_copies(start, this.getNGeneration_copies());
		
		if (func.it_is_correct(this.perfect_score_value(), start, this.getTarget()) == 0) {
			int score = 0;
			String best_generation_string = copies.get(0);
			
			while (score < this.perfect_score_value() && generation < 500) {
				
				copies = func.matrix_string_copies(best_generation_string, this.getNGeneration_copies());
				
				ArrayList<String> new_strings = new ArrayList<String>();
				generation++;
				int j = 0;
				
				while (j < this.getNGeneration_copies()) {
					new_strings.add(func.replace_characters(copies.get(j)));
					j++;
				}
				
				best_generation_string = func.best_string_so_far(new_strings, this.getTarget());
				score = func.string_points(best_generation_string, this.getTarget());
				System.out.println("Generation " + generation + ": " + best_generation_string + "-- score: " + score);
				
			}
		}
		
		/* This has chance of 1 in 10^40 */
		else {
			System.out.println("What a luck!!!");
			System.out.println("Generation " + generation + ": " + this.getTarget() + "-- score: " + this.perfect_score_value());
		}
		
		
	}


}
