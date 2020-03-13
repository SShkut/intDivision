package com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerDividerTest {

	IntegerDivider divider;
	DivisionResult result;

	@BeforeEach
	void setUp() throws Exception {
		divider = new IntegerDivider();
	}

	@Test
	void givenDividendGraterThanDivisor_whenDivide_thenQuotientPositive() {
		result = new DivisionResult(15012, 32, 469, new LinkedList<Integer>(Arrays.asList(128, 192, 288)), new LinkedList<Integer>(Arrays.asList(221, 292, 4)));
		assertEquals(result, divider.divide(15012, 32));
		
	}

	@Test
	void givenDividendLessThanDivisor_whenDivide_thenQuotientZero() {
		result = new DivisionResult(1271, 3112, 0, new LinkedList<Integer>(), new LinkedList<Integer>(Arrays.asList(1271)));
		assertEquals(result, divider.divide(1271, 3112));
	}

	@Test
	void givenDivisorEqualsZero_whenDivide_thenArithmeticException() {
		assertThrows(ArithmeticException.class, () -> divider.divide(1, 0));
	}

	@Test
	void givenDividendEqualsZero_whenDivide_thenQuoitientZero() {
		result = new DivisionResult(0, 1, 0, new LinkedList<Integer>(), new LinkedList<Integer>());
		assertEquals(result, divider.divide(0, 1));
	}

	@Test
	void givenDividendNegative_whenDivide_thenQuotionNegative() {
		result = new DivisionResult(-1114123, 111, -10037, new LinkedList<Integer>(Arrays.asList(111, 333, 777)), new LinkedList<Integer>(Arrays.asList(412, 793, 16)));
		assertEquals(result, divider.divide(-1114123, 111));
	}

	@Test
	void givenDivisorNegative_whenDivide_thenQuotionNegative() {
		result = new DivisionResult(223345, -54, -4136, new LinkedList<Integer>(Arrays.asList(216, 54, 162, 324)), new LinkedList<Integer>(Arrays.asList(73, 194, 325, 1)));
		assertEquals(result, divider.divide(223345, -54));
	}

	@Test
	void givenDivisorAndDividerNegative_whenDivide_thenQuotionPositive() {
		result = new DivisionResult(-29991, -400, 74, new LinkedList<Integer>(Arrays.asList(2800, 1600)), new LinkedList<Integer>(Arrays.asList(1991, 391)));
		assertEquals(result, divider.divide(-29991, -400));
	}

	@Test
	void givenDivisorAndDividendEqual_whenDivide_thenQuotionOne() {
		result = new DivisionResult(21478, 21478, 1, new LinkedList<Integer>(Arrays.asList(21478)), new LinkedList<Integer>(Arrays.asList(0)));
		assertEquals(result, divider.divide(21478, 21478));
	}
}
