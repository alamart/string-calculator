package org.kata.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
    void assertShouldReturn0forEmptyString() {
        assertEquals(StringCalculator.add(""), 0);
    }
	
	@Test
    void assertShouldReturn1for1AsString() {
        assertEquals(StringCalculator.add("1"), 1);
    }
	
	@Test
    void assertShouldReturn3for1And2AsString() {
        assertEquals(StringCalculator.add("1,2"), 3);
    }
	
	@Test
    void assertShouldHandleunknownAmountOfNumbers() {
        assertEquals(StringCalculator.add("1,2,3,4,6,3,8,9"), 36);
    }
}