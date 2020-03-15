package com.foxminded.integerdivision;

import static java.lang.String.valueOf;

import java.util.Queue;

public class IntegerDividerFormatter {

	public String format(DivisionResult divisionResult) {
		if (divisionResult == null) {
			return "";
		}
		
		int dividend = divisionResult.getDividend();
		int divisor = divisionResult.getDivisor();
		int quotient = divisionResult.getQuotient();
		Queue<Integer> intermediateValues = divisionResult.getIntermediateValues();
		Queue<Integer> reminders = divisionResult.getReminders();
		StringBuilder answer = new StringBuilder();
		String newLine = System.lineSeparator();
		
		answer.append(dividend + "|" + divisor + newLine);
		answer.append(intermediateValues.isEmpty() ? 0 : intermediateValues.peek());
		answer.append(getRepeatedString(" ", valueOf(dividend).length() - valueOf(intermediateValues.isEmpty() ? 0 : intermediateValues.remove()).length()) + "|------" + newLine);
		answer.append("-" + getRepeatedString(" ", valueOf(dividend).length() - 1) + "|" + quotient + newLine);
		
		int offset = 1;
		while (!intermediateValues.isEmpty()) {
			while (!reminders.isEmpty()) {
				answer.append(getRepeatedString(" ", offset) + reminders.remove() + newLine);
				answer.append(getRepeatedString(" ", offset) + intermediateValues.remove() + newLine);
				answer.append(getRepeatedString(" ", offset) + "--" + newLine);
				break;
			}
			offset++;
		}
		if (!reminders.isEmpty()) {
			answer.append(getRepeatedString(" ", valueOf(dividend).length() - valueOf(reminders.peek()).length()) + reminders.remove());
		}
		return answer.toString();
	}

	private String getRepeatedString(String character, int times) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < times; i++) {
			result.append(character);
		}
		return result.toString();
	}
}
