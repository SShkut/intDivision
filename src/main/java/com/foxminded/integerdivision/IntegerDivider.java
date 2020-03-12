package com.foxminded.integerdivision;

public class IntegerDivider {

	public int divide(int dividend, int divisor) {
		int quotient = 0;
		int radix = 10;
		int actionNumber = 0;
		int intermediateResult;
		if (divisor == 0) {
			return 0;
		}
		if (dividend == 0) {
			return 0;
		}
		
		int dividendLength = (logb(radix, Math.abs(dividend) +1));
		int position = (int) Math.pow(radix, dividendLength);
		int currentDividend = dividend / position;
		
		while (position >= 1) {
			if (Math.abs(currentDividend) >= divisor) {
				quotient *= radix;
				quotient += currentDividend / divisor;			
				intermediateResult = (quotient % radix) * divisor;
				currentDividend -= intermediateResult;
				actionNumber = 0;
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
		return quotient;
	}
	
	private int logb(int base, int value) {		
		return (int) (Math.log(value) / Math.log(base));
	}
}
