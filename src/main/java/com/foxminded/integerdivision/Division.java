package com.foxminded.integerdivision;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Division {

	public String divide(String dividendInput, String divisorInput) {
		if (divisorInput.contentEquals("0")) {
			return "Division by zero is not possible";
		}
		if (dividendInput.equals("0")) {
			return "0";
		}
		if (!validate(dividendInput) || !validate(divisorInput)) {
			return "Not numerical value.";
		}
		
		Sign quotionSign = Sign.POSITIVE;
		if (getSign(dividendInput) == Sign.NEGATIVE ^ getSign(divisorInput) == Sign.NEGATIVE) {
			quotionSign = Sign.NEGATIVE;
		}

		String dividendUnsign = getUnsignedStringNumber(dividendInput);
		String divisorUnsign = getUnsignedStringNumber(divisorInput);
		StringBuilder quotient = new StringBuilder();
		List<String> reminders = new ArrayList<>();
		List<String> dividends = new ArrayList<>();
		int divisor = parseInt(divisorUnsign);
		String[] digits = dividendUnsign.split("");
		StringBuilder currentDividend = new StringBuilder();
		
		for (int i = 0; i < digits.length; ++i) {
			currentDividend.append(digits[i]);
			int currentIntDividend = parseInt(currentDividend.toString());
			if (currentIntDividend >= divisor) {
				dividends.add(currentDividend.toString());
				quotient.append(currentIntDividend / divisor);
				int reminder = (currentIntDividend / divisor) * divisor;
				reminders.add(valueOf(reminder));
				currentIntDividend -= reminder;
				currentDividend.setLength(0);
				currentDividend.append(currentIntDividend);
			} else if (quotient.length() > 0 ) {
				quotient.append("0");
			}			
			if (currentDividend.length() == digits.length) {
				currentIntDividend = parseInt(currentDividend.toString());
				dividends.add(currentDividend.toString());
				quotient.append(currentIntDividend / divisor);
				int reminder = (currentIntDividend / divisor) * divisor;
				reminders.add(valueOf(reminder));
			}
		}
		if (quotionSign == Sign.NEGATIVE) {
			quotient.insert(0, "-");
		}
		return consoleVisualisation(quotient.toString(), reminders, dividendInput, divisorInput, dividends);
	}	

	private enum Sign {
		POSITIVE, NEGATIVE
	}

	private String getUnsignedStringNumber(String divisorInput) {
		String divisorUnsign = divisorInput;
		if (getSign(divisorInput) == Sign.NEGATIVE) {
			divisorUnsign = divisorInput.substring(1);
		}
		return divisorUnsign;
	}

	private boolean validate(String number) {
		try {
			parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Sign getSign(String number) {
		if (number.startsWith("-")) {
			return Sign.NEGATIVE;
		}
		return Sign.POSITIVE;
	}

	private String consoleVisualisation(String quotient, List<String> reminders, String dividend, String divisor, List<String> dividends) {
		StringBuilder answer = new StringBuilder();
		answer.append(dividend + "|" + divisor + "\n");
		answer.append(reminders.get(0) + getRepeatedString(" ", dividend.length() - reminders.get(0).length()) + "|------\n");
		answer.append("-" + getRepeatedString(" ", dividend.length() - 1) + "|" + quotient + "\n");
		int offset = 1;
		for (; offset < reminders.size(); offset++) {
			answer.append(getRepeatedString(" ", offset) + dividends.get(offset) + "\n");
			answer.append(getRepeatedString(" ", offset) + reminders.get(offset) + "\n");
			answer.append(getRepeatedString(" ", offset) + "--\n");
		}
		answer.append(getRepeatedString(" ", offset + 1));
		answer.append(Math.abs(parseInt(dividend) % parseInt(divisor)));
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
