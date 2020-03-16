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
		DivisionResult divisionResult = division.divide(dividend, divider);
		IntegerDividerFormatter formatter = new IntegerDividerFormatter();
		System.out.println(formatter.format(divisionResult));
		scanner.close();
	}
}