import java.io.*;
import java.text.BreakIterator;
import java.util.Locale;

import static sensitive_information_regex.AddressRegex.maskAddress;
import static sensitive_information_regex.BankInfoRegex.*;
import static sensitive_information_regex.EgyptianNationalIDNumberRegex.maskNationalId;
import static sensitive_information_regex.EgyptianPhoneNumberRegex.maskPhoneNumber;
import static sensitive_information_regex.EmailRegex.maskEmail;

public class FileManager {


    // ===============================================================================================


    /**
     * read the file
     *
     * @param filePath of the file that will be read
     * @return the string that in the file
     */
    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }


    // ===============================================================================================

    /**
     *
     * write the content in file
     *
     * @param filePath of the new file
     * @param content that will be written in the file
     */

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }


    // ===============================================================================================


    /**
     * Processes text by splitting it into sentences
     *
     * @param text The input text
     */
    public static String processText(String text) {
        // this to get sentence by sentence from the text
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(text);

        // the new text after applying the masked
        StringBuilder maskedText = new StringBuilder();

        // loop on the text and apply different mask in each sentence
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
            String sentence = text.substring(start, end).trim();
            sentence = maskEmail(sentence);
            sentence = maskIBAN(sentence);
            sentence = maskLocalAccount(sentence);
            sentence = maskNationalId(sentence);
            sentence = maskSwiftCode(sentence);
            sentence = maskPhoneNumber(sentence);
            sentence = maskAddress(sentence);
            maskedText.append(sentence).append("\n");
        }
        return maskedText.toString();
    }


    // ===============================================================================================

}
