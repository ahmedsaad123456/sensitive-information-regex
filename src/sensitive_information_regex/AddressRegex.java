package sensitive_information_regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AddressRegex {

    // ===============================================================================================

    /**
     * ================== Explain the Address Regex ============================
     * First we need to understand the address format:
     *
     * Building Number/Name, Street Name, Area/District/Neighborhood, City/Governorate, Postal
     * Code (optional), Country (Egypt)
     *
     * Building 1, El Tahrir Street, Dokki, Giza, 12611, Egypt (where 12611 is the
     * postal code)
     * El Nasr Street, Maadi, Cairo, Egypt
     * 10 El Hegaz Street, Near Roxy Square, Heliopolis, Cairo, Egypt
     * Apartment 7, 7th Floor, Building 77, 90th Street, New Cairo, Egypt
     * Talaat Harb Str., Downtown Cairo, 11511, Egypt (where 11511 is the postal
     * code)
     *
     * The address format and the examples provided with the assignment make conflict
     * So we need to redefine the address format from the examples
     *
     * First example meets the address format correctly
     * Second example is not, as the building Number/name is not found, so it must be optional
     * Third example has the same problem of the second
     * Fourth example has 2 new parts in the start (apartment number and floor number) so it must be added in the format and be optional
     * Fifth example has the same problem of the second and "Area/District/Neighborhood" is not found, so it must be optional
     *
     * the New address format :
     * Apartment number(optional), Floor number(optional), Building Number/Name(optional), Street Name, Area/District/Neighborhood(optional),
     * City/Governorate, Postal Code (optional), Country (Egypt)
     *
     * So we have 6 parts before the postal code with the same format as it allow anything separated by comma
     * but with at least 2 parts must be existed
     *
     * any chars except the comma is allowed
     * ([^,]+)(,[^,]+){1,5}
     *
     * Then postal code is optional
     * (,(\d{5}))?
     *
     *
     * Then ends with comma and space optional and Egypt
     * ,\s*Egypt$
     *
     * 
     */

    public static final String ADDRESS_REGEX = "([^,]+)(,[^,]+){1,5}(,(\\d{5}))?,\\s*Egypt";

    private static final Pattern pattern = Pattern.compile(ADDRESS_REGEX);

    // ===============================================================================================

    /**
     * Replaces any address in the sentence with '*' of the same length.
     *
     * @param sentence The sentence from the file
     * @return The modified sentence with address replaced or the original sentence if no address is found.
     */

    public static String maskAddress(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        return pattern.matcher(sentence).replaceAll(match -> "*".repeat(match.group().length()));
    }

    // ===============================================================================================


}
