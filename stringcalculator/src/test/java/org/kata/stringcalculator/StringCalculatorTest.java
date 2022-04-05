package org.kata.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
    void assertShouldReturn0ForEmptyString() {
        assertEquals(StringCalculator.add(""), 0);
    }
	
	@Test
    void assertShouldReturn1For1AsString() {
        assertEquals(StringCalculator.add("1"), 1);
    }
	
	@Test
    void assertShouldReturn3For1And2AsString() {
        assertEquals(StringCalculator.add("1,2"), 3);
    }
	
	@Test
    void assertShouldHandleUnknownAmountOfNumbers() {
        assertEquals(StringCalculator.add("1,2,3,4,6,3,8,9"), 36);
    }

	@Test
    void assertShouldReturn6For1AndNewlineCharAnd2And3() {
        assertEquals(StringCalculator.add("1\n2,3"), 6);
    }

	@Test
    void assertShouldReturn3For1And2AndDefaultDelimiter() {
        assertEquals(StringCalculator.add("//;\n1;2"), 3);
    }
	
	@Test
    void shouldThrowErrorForNewlineAfterComma() {
		IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class, () ->{
			StringCalculator.add("-1,35,-5\n-8");
		});
		assertEquals("negatives not allowed " + List.of(-1,-5,-8).toString(), thrownException.getMessage());
    }
}