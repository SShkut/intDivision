package com.foxminded.integerdivision;

import java.util.LinkedList;
import java.util.Queue;

public class DivisionStep {
	
	private Queue<Integer> intermedeateValues;
	private Queue<Integer> reminders;	

	public DivisionStep() {
		intermedeateValues = new LinkedList<>();
		reminders = new LinkedList<>();
	}

	public Queue<Integer> getIntermedeateValues() {
		return intermedeateValues;
	}
	
	public void setIntermedeateValues(Queue<Integer> intermedeateValues) {
		this.intermedeateValues = intermedeateValues;
	}
	
	public void addIntermedeateValue(Integer intermedeateValue) {
		intermedeateValues.add(intermedeateValue);
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
		result = prime * result + ((intermedeateValues == null) ? 0 : intermedeateValues.hashCode());
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
		if (intermedeateValues == null) {
			if (other.intermedeateValues != null)
				return false;
		} else if (!intermedeateValues.equals(other.intermedeateValues))
			return false;
		if (reminders == null) {
			if (other.reminders != null)
				return false;
		} else if (!reminders.equals(other.reminders))
			return false;
		return true;
	}	
}
