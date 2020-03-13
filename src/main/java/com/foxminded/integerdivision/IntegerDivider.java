package com.foxminded.integerdivision;

public class IntegerDivider {

	public DivisionResult divide(int dividend, int divisor) {
		DivisionResult divisionResult = new DivisionResult(dividend, divisor);
		int quotient = 0;
		int radix = 10;
		int actionNumber = 0;
		boolean isFirstOperationPass = false;
		if (divisor == 0) {
			throw new ArithmeticException("Division by 0 is undefined.");
		}
		if (dividend == 0) {
			divisionResult.setQuotient(0);
			return divisionResult;
		}
		
		int dividendLength = (logb(radix, Math.abs(dividend) +1));
		int position = (int) Math.pow(radix, dividendLength);
		int currentDividend = dividend / position;
		
		while (position >= 1) {
			if (Math.abs(currentDividend) >= Math.abs(divisor)) {
				if (isFirstOperationPass) {
					divisionResult.addReminder(Math.abs(currentDividend));
				}
				quotient *= radix;
				quotient += currentDividend / divisor;			
				int intermedeateValue = (quotient % radix) * divisor;
				divisionResult.addIntermedeateValue(Math.abs(intermedeateValue));				
				currentDividend -= intermedeateValue;
				actionNumber = 0;
				isFirstOperationPass = true;
			}
			if (position >= radix) {
				currentDividend *= radix;
				currentDividend += (dividend % position) / (position / radix);
			}			
			if (actionNumber >= 1) {
				quotient *= radix;
			}			
			actionNumber++;
			position /= radix;
		}
		divisionResult.setQuotient(quotient);
		divisionResult.addReminder(Math.abs(currentDividend));
		return divisionResult;
	}
	
	private int logb(int base, int value) {		
		return (int) (Math.log(value) / Math.log(base));
	}
}
