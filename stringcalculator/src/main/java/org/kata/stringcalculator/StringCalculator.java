package org.kata.stringcalculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	private static String SEPARATOR = ",";
	private static String NEWLINE_SEPARATOR = "\\n";

	private static String START_CHANGE_DELIMITER_SEPARATOR = "//";
	private static String DELIMITER_MATCHER_REGEX = String.format("^%s.*?%s", START_CHANGE_DELIMITER_SEPARATOR, NEWLINE_SEPARATOR);

	public static int add(String numbers) {
		if(isZeroSum(numbers)) {
			return 0;
		}
		String defaultDelimiter = getDelimiter(numbers);
		return addNumbers(numbers.replaceFirst(DELIMITER_MATCHER_REGEX, ""), defaultDelimiter);
	}

	private static int addNumbers(String numbers, String delimiter) {
		List<String> numbersList = splitNumbers(numbers, delimiter);
		return numbersList.stream().map(Integer::valueOf).reduce(0, (acc, current) -> acc+current);
	}
	
	private static boolean isZeroSum(String numbers) {
		return numbers == null || numbers.isEmpty();
	}
	
	private static List<String> splitNumbers(String allNumbers, String delimiter) {
		if(delimiter.isEmpty()) {
			return List.of(allNumbers.split(String.format("[%s%s]", SEPARATOR, NEWLINE_SEPARATOR)));			
		}
		return List.of(allNumbers.split(String.format("[%s]", delimiter)));
	}
	
	private static String getDelimiter(String numbers) {
		Pattern pattern = Pattern.compile(DELIMITER_MATCHER_REGEX);
		Matcher matcher = pattern.matcher(numbers);
		if(matcher.find()) {
			return (String) matcher.group().subSequence(2, matcher.group().length()-1);
		}
		return "";
	}
}