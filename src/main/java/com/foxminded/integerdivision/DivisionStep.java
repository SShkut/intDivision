package com.foxminded.integerdivision;

import java.util.LinkedList;
import java.util.Queue;

public class DivisionStep {
	
	private Queue<Integer> intermediateValues;
	private Queue<Integer> reminders;	

	public DivisionStep() {
		intermediateValues = new LinkedList<>();
		reminders = new LinkedList<>();
	}

	public Queue<Integer> getIntermediateValues() {
		return intermediateValues;
	}
	
	public void setIntermediateValues(Queue<Integer> intermediateValues) {
		this.intermediateValues = intermediateValues;
	}
	
	public void addIntermediateValue(Integer intermediateValue) {
		intermediateValues.add(intermediateValue);
	}
	
	public Queue<Integer> getReminders() {
		return reminders;
	}
	
	public void setReminders(Queue<Integer> reminders) {
		this.reminders = reminders;
	}
	
	public void addReminder(Integer reminder) {
		reminders.add(reminder);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intermediateValues == null) ? 0 : intermediateValues.hashCode());
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
		DivisionStep other = (DivisionStep) obj;
		if (intermediateValues == null) {
			if (other.intermediateValues != null)
				return false;
		} else if (!intermediateValues.equals(other.intermediateValues))
			return false;
		if (reminders == null) {
			if (other.reminders != null)
				return false;
		} else if (!reminders.equals(other.reminders))
			return false;
		return true;
	}	
}
