package problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problems_3_6_9_12_regex {

    /**
     * First we have 2 format for the data time
     *
     * ● YYYY/MM/DD (e.g., 2024/03/11)
     * ● YYYY-MM-DD (e.g., 2024-03-11)
     *
     * this mean it start with the year
     * ^(\d{4})
     *
     * then the separator
     * [-/]
     *
     * then the month number,
     * and it should be between 1-12
     * (0[1-9]|1[0-2]
     *
     *
     * then the separator
     * [-/]
     * then the day number,
     * and it should be between 1-31
     * (0[1-9]|[12]\d|3[01])
     *
     *
     * the second format
     *
     * ● DD/MM/YYYY (e.g., 11/03/2024)
     * ● D/MM/YYYY (e.g., 1/03/2024)
     * ● DD/M/YYYY (e.g., 11/3/2024)
     * ● DD-MM-YYYY (e.g., 11-03-2024)
     * ● D-MM-YYYY (e.g., 1-03-2024)
     * ● DD-M-YYYY (e.g., 11-3-2024)
     *
     *
     * it starts with the day number, and it could be one digit or two digit,
     * and it should be between 1-31
     *
     * (0?[1-9]|[12]\d|3[01])
     *
     * then the separator
     * [-/]
     *
     * then the month number, and it could be one digit or two digit,
     * and it should be between 1-12
     *
     * then the separator
     * [-/]
     *
     * then ends with the year
     * (\d{4})$
     *
     */

    private static final String PROBLEM_3_REGEX =
            "^(\\d{4})[-/](0[1-9]|1[0-2])[-/](0[1-9]|[12]\\d|3[01])$" +
                    "|^(0?[1-9]|[12]\\d|3[01])[-/](0?[1-9]|1[0-2])[-/](\\d{4})$";

    // ==================================================================================================

    /**
     *
     * it should odd number of b (uppercase or lower case)
     * then it should be at least 1 b
     *
     * [aA]*[bB]
     *
     * then if any b appear it must appear with another b
     *
     * (?:[aA]*[bB][aA]*[bB])*
     *
     * and could end with a or A
     *
     * [aA]*$
     *
     */
    private static final String PROBLEM_6_REGEX = "^[aA]*[bB](?:[aA]*[bB][aA]*[bB])*[aA]*$";

    // ==================================================================================================
    /**
     *
     * First the time stamp in between two [ ] and with the following format
     *
     * 2023-10-15 14:30:45
     *
     * \[(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2})\]
     *
     * then the level in between two [ ]
     * \[([A-Z]+)\]
     *
     * then ends with any words and this is the message
     * (.+)
     *
     */
    private static final String PROBLEM_9_REGEX = "\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\] \\[([A-Z]+)\\] (.+)"; // Add regex here

    // ==================================================================================================

    /**
     * First we need if the digit appear it should be followed by letters and the inverse is right
     *
     * letter followed by digit
     * [a-zA-Z]\d)+
     *
     *
     * and it can end with letter
     * [a-zA-Z]?
     *
     * Or digit followed by letter
     * \d[a-zA-Z]
     *
     *
     * and it can end with digit
     * \d?
     *
     */

    private static final String PROBLEM_12_REGEX = "^(?:[a-zA-Z]\\d)+[a-zA-Z]?$|^(?:\\d[a-zA-Z])+\\d?$";


    // ==================================================================================================

    private static final Pattern PROBLEM_3_PATTERN = Pattern.compile(PROBLEM_3_REGEX);
    private static final Pattern PROBLEM_6_PATTERN = Pattern.compile(PROBLEM_6_REGEX);
    private static final Pattern PROBLEM_9_PATTERN = Pattern.compile(PROBLEM_9_REGEX);
    private static final Pattern PROBLEM_12_PATTERN = Pattern.compile(PROBLEM_12_REGEX);

    // ==================================================================================================


    public static String isValidProblem3(String input) {
        return PROBLEM_3_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    // ==================================================================================================


    public static String isValidProblem6(String input) {
        return PROBLEM_6_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    // ==================================================================================================


    public static String isValidProblem9(String input) {
        Matcher matcher = PROBLEM_9_PATTERN.matcher(input);

        if (matcher.matches()) {
            // Extract timestamp
            String timestamp = matcher.group(1);
            // Extract log level
            String level = matcher.group(2);
            // Extract message
            String message = matcher.group(3);

            return String.format("Timestamp: %s, Level: %s, Message: %s", timestamp, level, message);
        }

        return "Invalid log entry"; // If input doesn't match
    }

    // ==================================================================================================


    public static String isValidProblem12(String input) {
        return PROBLEM_12_PATTERN.matcher(input).matches() ? "valid" : "invalid";
    }

    // ==================================================================================================

}

