package sensitive_information_regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BankInfoRegex {

    // ===============================================================================================

    /**
     * ================== Explain the local account Regex ============================
     *
     * The local account must contain 17 digits allowing space
     *
     * first 12 digit and it can contain space after each 4 digit or not
     * (\d{4}\s?){3}
     *
     * it ends with 5 digits
     * \\d{5}
     *
     */
    public static final String LOCAL_ACCOUNT_REGEX = "(\\d{4}\\s?){3}\\d{5}";
    private static final Pattern localAccountPattern = Pattern.compile(LOCAL_ACCOUNT_REGEX);

    // ===============================================================================================

    /**
     * ================== Explain the Iban Regex ============================
     *
     * The local Iban must contain 29 chars allowing space with country code in the first
     * EG\d{2}
     *
     * first 12 digit and it can contain space after each 4 digit or not
     * (\d{4}\s?){3}
     *
     * it ends with 5 digits
     * \\d{5}
     *
     * then contain 24 digits with allowing space before each 4 digit
     * (?:\s?\d{4}){6}
     *
     * and with one digit in the end and may be space before
     * \\s?\\d
     *
     */
    public static final String IBAN_REGEX = "EG\\d{2}(\\s?\\d{4}){6}\\s?\\d";
    private static final Pattern ibanPattern = Pattern.compile(IBAN_REGEX);


    // ===============================================================================================

    /**
     * ================== Explain the swift code Regex ============================
     *
     * The SWIFT code consists of 8 to 11 characters (letters and digits) and the letters must be uppercase
     *
     * First 6 characters (only letters)
     * [A-Z]{6}
     *
     * Next 2 characters (letters and digits)
     * [A-Z0-9]{2}
     *
     * Last 3 characters (letters and digits)(optional)
     * ([A-Z0-9]{3})?
     *
     */
    public static final String SWIFT_CODE_REGEX = "[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?";
    private static final Pattern swiftCodePattern = Pattern.compile(SWIFT_CODE_REGEX);

    // ===============================================================================================

    /**
     * Replaces any local account in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with local account replaced or the original sentence if no local account is found.
     */

    public static String maskLocalAccount(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        return localAccountPattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================


    /**
     * Replaces any IBAN in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with IBAN replaced or the original sentence if no IBAN is found.
     */

    public static String maskIBAN(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        return ibanPattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================


    /**
     * Replaces any swift code in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with swift code replaced or the original sentence if no swift code is found.
     */

    public static String maskSwiftCode(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        return swiftCodePattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================

}
