package com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionTest {

	IntegerDivider division;

	@BeforeEach
	void setUp() throws Exception {
		division = new IntegerDivider();
	}

	@Test
	void givenDividendGraterThanDivisor_whenDivide_thenQuotientPositive() {
		assertEquals(15012 / 32, division.divide(15012, 32));
		
	}

	@Test
	void givenDividendLessThanDivisor_whenDivide_thenQuotientZero() {
		assertEquals(1271 / 3112, division.divide(1271, 3112));
	}

	@Test
	void givenDivisorEqualsZero_whenDivide_thenProhibitedOperation() {
		assertEquals(0, division.divide(1, 0));
	}

	@Test
	void givenDividendEqualsZero_whenDivide_thenQuoitientZero() {
		assertEquals(0, division.divide(0, 1));
	}

	@Test
	void givenDividendNegative_whenDivide_thenQuotionNegative() {
		assertEquals(-1114123 / 111, division.divide(-1114123, 111));
	}

	@Test
	void givenDivisorNegative_whenDivide_thenQuotionNegative() {
		assertEquals(223345 / -54, division.divide(223345, -54));
	}

	@Test
	void givenDivisorAndDividerNegative_whenDivide_thenQuotionPositive() {
		assertEquals(-29991 / -400, division.divide(-29991, -400));
	}

	@Test
	void givenDivisorAndDividendEqual_whenDivide_thenQuotionOne() {
		assertEquals(21478 / 21478, division.divide(21478, 21478));
	}
}
