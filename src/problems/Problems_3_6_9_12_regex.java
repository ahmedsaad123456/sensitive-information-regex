package problems;

import java.util.regex.Pattern;

public class Problems_3_6_9_12_regex {

    private static final String PROBLEM_3_REGEX = ""; // Add regex here
    private static final String PROBLEM_6_REGEX = ""; // Add regex here
    private static final String PROBLEM_9_REGEX = ""; // Add regex here
    private static final String PROBLEM_12_REGEX = ""; // Add regex here

    private static final Pattern PROBLEM_3_PATTERN = Pattern.compile(PROBLEM_3_REGEX);
    private static final Pattern PROBLEM_6_PATTERN = Pattern.compile(PROBLEM_6_REGEX);
    private static final Pattern PROBLEM_9_PATTERN = Pattern.compile(PROBLEM_9_REGEX);
    private static final Pattern PROBLEM_12_PATTERN = Pattern.compile(PROBLEM_12_REGEX);

    public static String isValidProblem3(String input) {
        return PROBLEM_3_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem6(String input) {
        return PROBLEM_6_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem9(String input) {
        return PROBLEM_9_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem12(String input) {
        return PROBLEM_12_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}
