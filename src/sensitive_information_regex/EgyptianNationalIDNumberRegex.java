package sensitive_information_regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EgyptianNationalIDNumberRegex {


    // ===============================================================================================

    /**
     * ================== Explain the national id Regex ============================
     *
     *  The string must contain only 14 digits without space
     * - `(?<!\d)` to ensure the 14 digits are NOT preceded by another digit.
     * - `(?!\d)` to ensure the 14 digits are NOT followed by another digit.
     *
     */

//    public static final String NATIONAL_ID_REGEX = "(?<!\\d)\\d{14}(?!\\d)";


    /**
     * ================== Explain the national id Regex ============================
     *
     * -`(?<!\d)` to ensure the 14 digits are NOT preceded by another digit.
     *
     *
     *  "[123]" Century digit: 1 or 2 or 3
     *
     *  "\\d{2}" Year of birth: any two digits
     *
     *   "(0[1-9]|1[0-2])" Month of birth: 01-12
     *
     *
     *   "(0[1-9]|[12][0-9]|3[01])" Day of birth: 01-31
     *
     *
     *   "(0[1-9]|[1-7]\\d|8[0-8])" Governor code: 01-88
     *
     *   "\\d{5}"  Serial number: any five digits
     *
     *   `(?!\d)` to ensure the 14 digits are NOT followed by another digit.
     */
    public static final String NATIONAL_ID_REGEX =
            "(?<!\\d)" +
                    "[123]" +
                    "\\d{2}" +
                    "(0[1-9]|1[0-2])" +
                    "(0[1-9]|[12][0-9]|3[01])" +
                    "(0[1-9]|[1-7]\\d|8[0-8])" +
                    "\\d{5}" +
                    "(?!\\d)";


    private static final Pattern pattern = Pattern.compile(NATIONAL_ID_REGEX);


    // ===============================================================================================

    /**
     * Replaces any national id in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with national id replaced or the original sentence if no national id is found.
     */


    public static String maskNationalId(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        return pattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================


}
