package edu.century.pa4;

import java.util.Scanner;

/**
 * @author biniamlemma
 * This program calculates the binomial coefficient formula
 * and prints a frame of bowling pins using recursive method
 */
public class Recursion {
	private static Scanner scan;
	
	// Main function
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.print("Enter 'n': ");
		int n = scan.nextInt();
		System.out.print("Enter 'r': ");
		int r = scan.nextInt();
		System.out.println();
		System.out.println(fact(n, r));
		System.out.print("Enter the number of row for the bowling pins: ");
		int row = scan.nextInt();
		bowlingPins(row, "");
		System.out.println();

	}

	/**
	 * @param n
	 * @param r
	 * @return
	 * This recursive method calculates the binomial coefficient for given n and r.
	 */
	public static int fact(int n, int r) {

		if (n == 0 || r == 0 || n == r)
			return 1;
		else {
			int num1 = fact(n - 1, r - 1);
			int num2 = fact(n - 1, r);
			return num1 + num2;
		}
	}

	/**
	 * @param n
	 * @param y
	 * @return
	 * This recursive method display a frame of bowling pins 
	 */
	public static String bowlingPins(int n, String y) {
		String x = "";
		if (n != 0) {
			x += "* ";
			y += " ";
			x += bowlingPins(--n, y);
			System.out.println(y + x);
			y = "";
			return x;
		} else
			return "";

	}
}
