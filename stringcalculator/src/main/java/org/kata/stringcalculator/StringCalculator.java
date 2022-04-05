package org.kata.stringcalculator;

import java.util.List;

public class StringCalculator {

	public static int add(String numbers) {
		if(isZeroSum(numbers)) {
			return 0;
		}
		List<String> numbersList = List.of(numbers.split(","));
		return numbersList.stream().map(Integer::valueOf).reduce(0, (acc, current) -> acc+current);
	}
	
	private static boolean isZeroSum(String numbers) {
		return numbers == null || numbers.isEmpty();
	}
	

}