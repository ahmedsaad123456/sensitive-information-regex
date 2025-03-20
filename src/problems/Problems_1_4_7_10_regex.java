package problems;

import java.util.regex.Pattern;

public class Problems_1_4_7_10_regex {

    private static final String PROBLEM_1_REGEX = ""; // Add regex here
    private static final String PROBLEM_4_REGEX = ""; // Add regex here
    private static final String PROBLEM_7_REGEX = ""; // Add regex here
    private static final String PROBLEM_10_REGEX = ""; // Add regex here

    private static final Pattern PROBLEM_1_PATTERN = Pattern.compile(PROBLEM_1_REGEX);
    private static final Pattern PROBLEM_4_PATTERN = Pattern.compile(PROBLEM_4_REGEX);
    private static final Pattern PROBLEM_7_PATTERN = Pattern.compile(PROBLEM_7_REGEX);
    private static final Pattern PROBLEM_10_PATTERN = Pattern.compile(PROBLEM_10_REGEX);

    public static String isValidProblem1(String input) {
        return PROBLEM_1_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem4(String input) {
        return PROBLEM_4_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem7(String input) {
        return PROBLEM_7_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem10(String input) {
        return PROBLEM_10_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}
