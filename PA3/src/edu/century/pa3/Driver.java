package edu.century.pa3;

import java.util.Scanner;

public class Driver {

	/***********************************************
	 * main function to test the program.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str = args[0]; 
		//String str = input.next();
		if (SimpleParser.isBalanced(str)){
			System.out.println("it's balanced");
		}else {
			System.out.println("it's not balanced");
			System.out.println("Missing left version of " + SimpleParser.missing());
		}
	}

}
