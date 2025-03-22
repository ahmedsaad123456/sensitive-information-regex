package problems;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Problems_2_5_8_11_regex {

    private static final String PROBLEM_2_REGEX = "^b*(a(b|bbb))*b*$"; // Add regex here
    private static final String PROBLEM_5_REGEX = "^[a-zA-Z_][a-zA-Z0-9_]*$"; // Add regex here
    private static final String PROBLEM_8_REGEX = "\\b\\w{5}(\\w{5})*\\b"; // Add regex here
    private static final String PROBLEM_11_REGEX = "^(\\S+\\s+){6}\\S+$"; // Add regex here

    private static final Pattern PROBLEM_2_PATTERN = Pattern.compile(PROBLEM_2_REGEX, Pattern.CASE_INSENSITIVE);
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
        Matcher matcher = PROBLEM_8_PATTERN.matcher(input);
        String result = "**" + input + "**\n";

        int matchCount = 0;
        String matches = "";

        while (matcher.find()) {
            matchCount++;
            matches += matcher.group() + " [" + matcher.start() + ", " + matcher.end() + "]\n";
        }

        if (matchCount == 0) {
            result += "No word matches\n";
        } else {
            result += "Number of matched words: " + matchCount + "\n" + matches;
        }

        return result;
    }


    public static String isValidProblem11(String input) {
        return PROBLEM_11_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }
}
