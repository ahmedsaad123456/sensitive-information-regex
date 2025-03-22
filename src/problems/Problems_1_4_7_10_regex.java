package problems;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Problems_1_4_7_10_regex {

    private static final String PROBLEM_1_REGEX = "^([0-9A-Fa-f]{2}([-:]?)){5}[0-9A-Fa-f]{2}$" ; // Add regex here
    private static final String PROBLEM_4_REGEX = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}$"; // Add regex here

    private static final String PROBLEM_7_REGEX = "(aa|bb)*(ab|ba)((aa|bb)*(ab|ba)(aa|bb)*(ab|ba))*(aa|bb)*";
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
        Matcher matcher = PROBLEM_7_PATTERN.matcher(input);

        StringBuilder result = new StringBuilder();
        int count = 0;

        while (matcher.find()) {
            count++;
            result.append(matcher.group()).append(" [")
                    .append(matcher.start()).append(", ").append(matcher.end()).append("]\n");
        }

        if (count == 0) return "No matches found.";

        result.insert(0,  "**" + input + "**\n" + "Number of matched substrings: " + count + "\n");

        result.append("---------------------------------------------");
        return result.toString();
    }

    public static String isValidProblem10(String input) {
        return PROBLEM_10_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}