package weasel_program;


public class Main {
	
	static String target = "METHINKS IT IS LIKE A WEASEL";
	static int copies = 100;

	public static void main(String[] args) {
		
		Weasel_program program = new Weasel_program(copies, target);
		
		program.execution();

	}

}
