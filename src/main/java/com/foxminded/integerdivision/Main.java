package com.foxminded.integerdivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);
		Division division = new Division();
		System.out.print("Enter a dividend: ");
		String dividend = scanner.nextLine();
		System.out.print("Enter a divider: ");
		String divider = scanner.nextLine();
		System.out.println(division.divide(dividend, divider));
		scanner.close();
	}
}
