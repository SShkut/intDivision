package com.foxminded.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerDividerFormatterTest {
	
	private final static String NEWLINE = System.lineSeparator();
	IntegerDividerFormatter formatter;
	DivisionResult result;

	@BeforeEach
	void setUp() throws Exception {
		formatter = new IntegerDividerFormatter();
	}

	@Test
	void givenDivisionResultNull_whenFormat_thenNullPointerExceptioin() {
		assertThrows(NullPointerException.class, () -> formatter.format(null));
	}

	@Test
	void givenDivisionResultEmpty_whenFormat_thenNullPointerException () {
		assertThrows(NullPointerException.class, () -> formatter.format(result));
	}
	
	@Test
	void givenDivisionResult_whenFormat_thenGetFormattedOutput() {
		result = new DivisionResult(11323, 67, 169, new LinkedList<Integer>(Arrays.asList(67, 402, 603)), new LinkedList<Integer>(Arrays.asList(462, 603, 0)));
		StringBuilder expected = new StringBuilder();
		expected.append("11323|67" + NEWLINE)
				.append("67   |------" + NEWLINE)
				.append("-    |169" + NEWLINE)
				.append(" 462" + NEWLINE)
				.append(" 402" + NEWLINE)
				.append(" --" + NEWLINE)
				.append("  603" + NEWLINE)
				.append("  603" + NEWLINE)
				.append("  --" + NEWLINE)
				.append("    0");
		assertEquals(expected.toString(), formatter.format(result));	
	}
}
