package com.foxminded.integerdivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		IntegerDivider division = new IntegerDivider();
		System.out.print("Enter a dividend: ");
		int dividend = scanner.nextInt();
		System.out.print("Enter a divider: ");
		int divider = scanner.nextInt();
		System.out.println(division.divide(dividend, divider));
		scanner.close();
	}
}