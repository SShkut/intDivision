package com.foxminded.integerdivision;

import java.util.LinkedList;
import java.util.Queue;

public class DivisionResult {
	private final int dividend;
	private final int divisor;
	private int quotion;
	private Queue<Integer> intermedeateValues;
	private Queue<Integer> reminders;
	
	public DivisionResult(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		intermedeateValues = new LinkedList<>();
		reminders = new LinkedList<>();
	}	

	public DivisionResult(int dividend, int divisor, int quotion, Queue<Integer> intermedeateValues, Queue<Integer> reminders) {
		super();
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotion = quotion;
		this.intermedeateValues = intermedeateValues;
		this.reminders = reminders;
	}

	public int getDividend() {
		return dividend;
	}

	public int getDivisor() {
		return divisor;
	}
	
	public Queue<Integer> getIntermedieateValues() {
		return intermedeateValues;
	}
	
	public void addIntermedeateValue(int intermedeateValue) {
		intermedeateValues.add(intermedeateValue);
	}

	public Queue<Integer> getReminders() {
		return reminders;
	}
	
	public void addReminder(int reminder) {
		reminders.add(reminder);
	}

	public int getQuotion() {
		return quotion;
	}
	
	public void setQuotion(int quotion) {
		this.quotion = quotion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dividend;
		result = prime * result + divisor;
		result = prime * result + ((intermedeateValues == null) ? 0 : intermedeateValues.hashCode());
		result = prime * result + quotion;
		result = prime * result + ((reminders == null) ? 0 : reminders.hashCode());
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
		if (divisor != other.divisor)
			return false;
		if (intermedeateValues == null) {
			if (other.intermedeateValues != null)
				return false;
		} else if (!intermedeateValues.equals(other.intermedeateValues))
			return false;
		if (quotion != other.quotion)
			return false;
		if (reminders == null) {
			if (other.reminders != null)
				return false;
		} else if (!reminders.equals(other.reminders))
			return false;
		return true;
	}	
}
