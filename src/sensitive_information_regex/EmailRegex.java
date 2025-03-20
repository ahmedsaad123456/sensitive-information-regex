package sensitive_information_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {

    // ===============================================================================================

    /**
     * ================== Explain the Email Regex ============================
     *
     *
     * (?!.*[._+-]{2}) Lookahead to assert that the available special chars
     * cannot appear consecutively anywhere in the string
     *
     * The local part [a-zA-Z0-9]*[a-zA-Z0-9._+-]+[a-zA-Z0-9]*
     * cannot start or end with special chars and must contain at least one character
     *
     * The Domain Part that after "@" [a-zA-Z0-9.-]+\.(?=[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*$)[a-zA-Z0-9]{2,}$
     * Domain name ends with Top-Level Domain (TLD)
     *
     * Domain name [a-zA-Z0-9.-]+
     * must contain at least one character and if the one becomes . or -
     * this will be failure because the next part is . so the first lookahead will assert that
     *
     * Top-Level Domain (TLD) that after .
     * (?=[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*)[a-zA-Z0-9]{2,}
     * can consist of letters only or a combination of letters and numbers
     * and the TLD length must be at least 2
     *
     */
    private static final String EMAIL_REGEX = "(?!.*[._+-]{2})[a-zA-Z0-9]*[a-zA-Z0-9._+-]+[a-zA-Z0-9]*@[a-zA-Z0-9.-]+\\.(?=[a-zA-Z0-9]*[a-zA-Z]+[a-zA-Z0-9]*)[a-zA-Z0-9]{2,}";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);


    // ===============================================================================================

    /**
     * Replaces any email in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with email replaced or the original sentence if no email is found.
     */

    public static String maskEmail(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        return pattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }
    // ===============================================================================================

}
