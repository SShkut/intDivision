package com.foxminded.integerdivision;

import static java.lang.String.valueOf;

import java.util.Queue;

public class IntegerDividerFormatter {

	public String consoleVisualisation(DivisionResult divisionResult) {
		int dividend = divisionResult.getDividend();
		int divisor = divisionResult.getDivisor();
		int quotient = divisionResult.getQuotion();
		Queue<Integer> intermediateValues = divisionResult.getIntermedieateValues();
		Queue<Integer> reminders = divisionResult.getReminders();
		StringBuilder answer = new StringBuilder();
		
		answer.append(dividend + "|" + divisor + "\n");
		answer.append(intermediateValues.isEmpty() ? 0 : intermediateValues.peek());
		answer.append(getRepeatedString(" ", valueOf(dividend).length() - valueOf(intermediateValues.isEmpty() ? 0 : intermediateValues.remove()).length()) + "|------\n");
		answer.append("-" + getRepeatedString(" ", valueOf(dividend).length() - 1) + "|" + quotient + "\n");
		
		int offset = 1;
		while (!intermediateValues.isEmpty()) {
			while (!reminders.isEmpty()) {
				answer.append(getRepeatedString(" ", offset) + reminders.remove() + "\n");
				answer.append(getRepeatedString(" ", offset) + intermediateValues.remove() + "\n");
				answer.append(getRepeatedString(" ", offset) + "--\n");
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
