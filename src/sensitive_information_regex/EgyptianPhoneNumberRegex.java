package sensitive_information_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EgyptianPhoneNumberRegex {


    // ===============================================================================================

    /**
     *
     * ================== Explain the Egyptian phone number Regex ============================
     *
     *
     * ^(0|\+20|\(\+20\))
     * it can start with 0 or +20 or (+20)
     *
     * Followed by any of the following
     * (10|11|12|15)
     *
     * and ends with exactly 8 numbers
     * [0-9]{8}$
     *
     *
     */
    private static final String EGYPTIAN_PHONE_REGEX =
            "(0|\\+20|\\(\\+20\\))(10|11|12|15)[0-9]{8}";



    private static final Pattern pattern = Pattern.compile(EGYPTIAN_PHONE_REGEX);


    // ===============================================================================================

    /**
     * Replaces any phone number in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with phone number replaced or the original sentence if no phone number is found.
     */

    public static String maskPhoneNumber(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        return pattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================


}
