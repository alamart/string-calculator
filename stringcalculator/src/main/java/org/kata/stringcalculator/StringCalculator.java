package org.kata.stringcalculator;

import java.util.List;

public class StringCalculator {
	
	private static String SEPARATOR = ",";
	private static String NEWLINE_SEPARATOR = "\\n";

	public static int add(String numbers) {
		if(isZeroSum(numbers)) {
			return 0;
		}
		List<String> numbersList = splitNumbers(numbers);
		return numbersList.stream().map(Integer::valueOf).reduce(0, (acc, current) -> acc+current);
	}
	
	private static boolean isZeroSum(String numbers) {
		return numbers == null || numbers.isEmpty();
	}
	
	private static List<String> splitNumbers(String allNumbers) {
		return List.of(allNumbers.split(String.format("[%s%s]", SEPARATOR, NEWLINE_SEPARATOR)));
	}
}