package com.foxminded.integerdivision;

import java.util.Queue;

public class DivisionResult {
	
	private final int dividend;
	private final int divisor;
	private int quotient;
	private DivisionStep divisionStep;
	
	public DivisionResult(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		divisionStep = new DivisionStep();
	}	

	public DivisionResult(int dividend, int divisor, int quotion, Queue<Integer> intermedeateValues, Queue<Integer> reminders) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = quotion;
		divisionStep = new DivisionStep();
		this.divisionStep.setIntermedeateValues(intermedeateValues);
		this.divisionStep.setReminders(reminders);
	}

	public int getDividend() {
		return dividend;
	}

	public int getDivisor() {
		return divisor;
	}
	
	public Queue<Integer> getIntermedieateValues() {
		return divisionStep.getIntermedeateValues();
	}
	
	public void addIntermedeateValue(int intermedeateValue) {
		divisionStep.addIntermedeateValue(intermedeateValue);
	}

	public Queue<Integer> getReminders() {
		return divisionStep.getReminders();
	}
	
	public void addReminder(int reminder) {
		divisionStep.addReminder(reminder);
	}

	public int getQuotient() {
		return quotient;
	}
	
	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dividend;
		result = prime * result + ((divisionStep == null) ? 0 : divisionStep.hashCode());
		result = prime * result + divisor;
		result = prime * result + quotient;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionResult other = (DivisionResult) obj;
		if (dividend != other.dividend)
			return false;
		if (divisionStep == null) {
			if (other.divisionStep != null)
				return false;
		} else if (!divisionStep.equals(other.divisionStep))
			return false;
		if (divisor != other.divisor)
			return false;
		if (quotient != other.quotient)
			return false;
		return true;
	}	
}
