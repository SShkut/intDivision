package com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionTest {

	Division division;

	@BeforeEach
	void setUp() throws Exception {
		division = new Division();
	}

	@Test
	void givenDividendGraterThanDivisor_whenDivide_thenQuotientPositive() {
		StringBuilder expected = new StringBuilder();
		expected.append("150|3\n")
				.append("15 |------\n")
				.append("-  |50\n")
				.append("  0");
		assertEquals(expected.toString(), division.divide("150", "3"));
		
	}

	@Test
	void givenDividendLessThanDivisor_whenDivide_thenQuotientZero() {
		StringBuilder expected = new StringBuilder();
		expected.append("127|311\n")
				.append("0  |------\n")
				.append("-  |0\n")
				.append("  127");
		assertEquals(expected.toString(), division.divide("127", "311"));
	}

	@Test
	void givenDivisorEqualsZero_whenDivide_thenProhibitedOperation() {
		assertEquals("Division by zero is not possible", division.divide("1", "0"));
	}

	@Test
	void givenDividendEqualsZero_whenDivide_thenQuoitientZero() {
		assertEquals("0", division.divide("0", "1"));
	}
	
	@Test
	void givenInvalidInput_whenDivide_thenErrorMessage() {
		assertEquals("Not numerical value.", division.divide("abc", "1"));
	}

	@Test
	void givenDividendNegative_whenDivide_thenQuotionNegative() {
		StringBuilder expected = new StringBuilder();
		expected.append("-1114|111\n")
				.append(" 111 |------\n")
				.append("-    |-10\n")
				.append("  4");
		assertEquals(expected.toString(), division.divide("-1114", "111"));
	}

	@Test
	void givenDivisorNegative_whenDivide_thenQuotionNegative() {
		StringBuilder expected = new StringBuilder();
		expected.append("223|-54\n")
				.append("216|------\n")
				.append("-  |-4\n")
				.append("  7");
		assertEquals(expected.toString(), division.divide("223", "-54"));
	}

	@Test
	void givenDivisorAndDividerNegative_whenDivide_thenQuotionPositive() {
		StringBuilder expected = new StringBuilder();
		expected.append("-2999|-400\n")
				.append(" 2800|------\n")
				.append("-    |7\n")
				.append("  199");
		assertEquals(expected.toString(), division.divide("-2999", "-400"));
	}

	@Test
	void givenDivisorAndDividendEqual_whenDivide_thenQuotionOne() {
		StringBuilder expected = new StringBuilder();
		expected.append("2147|2147\n")
				.append("2147|------\n")
				.append("-   |1\n")
				.append("  0");
		assertEquals(expected.toString(), division.divide("2147", "2147"));
	}
}
