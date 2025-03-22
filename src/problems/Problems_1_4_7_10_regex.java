package problems;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Problems_1_4_7_10_regex {

    private static final String PROBLEM_1_REGEX = "^([0-9A-Fa-f]{2}([-:]?)){5}[0-9A-Fa-f]{2}$" ; // Add regex here
    private static final String PROBLEM_4_REGEX = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$"; // Add regex here
    private static final String PROBLEM_7_REGEX = "[ab]+"; // Add regex here
    private static final String PROBLEM_10_REGEX = "^[+-]?(?:\\d+(\\.\\d+)?|[a-zA-Z])+([+\\-*/%^][+-]?(?:\\d+(\\.\\d+)?|[a-zA-Z])+)*=[+-]?(?:\\d+(\\.\\d+)?|[a-zA-Z])+([+\\-*/%^][+-]?(?:\\d+(\\.\\d+)?|[a-zA-Z])+)*$";
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
        StringBuilder result = new StringBuilder();
        result.append("**").append(input).append("**\n");

        ArrayList<String> validSubstrings = new ArrayList<>();

        // all possible substrings
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String sub = input.substring(i, j);

                // Ensure substring contains only 'a' and 'b'
                if (PROBLEM_7_PATTERN.matcher(input).matches()) {
                    
                    int countA = 0, countB = 0;
                    for (char c : sub.toCharArray()) {
                        if (c == 'a') countA++;
                        if (c == 'b') countB++;
                    }

                    // Check if both counts are odd
                    if (countA % 2 == 1 && countB % 2 == 1) {
                        validSubstrings.add(sub + " [" + i + ", " + (j - 1) + "]");
                    }
                }
            }
        }

        result.append("Number of matched substrings: ").append(validSubstrings.size()).append("\n");
        for (String s : validSubstrings) {
            result.append(s).append("\n");
        }
        result.append("-----------------------------------\n");

        return result.toString();
    }

    public static String isValidProblem10(String input) {
        return PROBLEM_10_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}
