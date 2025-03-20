package problems;

import java.util.regex.Pattern;

public class Problems_2_5_8_11_regex {

    private static final String PROBLEM_2_REGEX = ""; // Add regex here
    private static final String PROBLEM_5_REGEX = ""; // Add regex here
    private static final String PROBLEM_8_REGEX = ""; // Add regex here
    private static final String PROBLEM_11_REGEX = ""; // Add regex here

    private static final Pattern PROBLEM_2_PATTERN = Pattern.compile(PROBLEM_2_REGEX);
    private static final Pattern PROBLEM_5_PATTERN = Pattern.compile(PROBLEM_5_REGEX);
    private static final Pattern PROBLEM_8_PATTERN = Pattern.compile(PROBLEM_8_REGEX);
    private static final Pattern PROBLEM_11_PATTERN = Pattern.compile(PROBLEM_11_REGEX);

    public static String isValidProblem2(String input) {
        return PROBLEM_2_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem5(String input) {
        return PROBLEM_5_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem8(String input) {
        return PROBLEM_8_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    public static String isValidProblem11(String input) {
        return PROBLEM_11_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}
