package sensitive_information_regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EgyptianNationalIDNumberRegex {


    // ===============================================================================================

    /**
     * ================== Explain the national id Regex ============================
     *
     * The string must contain only 14 digits without space
     *
     */

    public static final String NATIONAL_ID_REGEX = "\\d{14}";
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
