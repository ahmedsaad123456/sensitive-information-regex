import java.io.*;
import java.text.BreakIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import static sensitive_information_regex.AddressRegex.maskAddress;
import static sensitive_information_regex.BankInfoRegex.*;
import static sensitive_information_regex.EgyptianNationalIDNumberRegex.maskNationalId;
import static sensitive_information_regex.EgyptianPhoneNumberRegex.maskPhoneNumber;
import static sensitive_information_regex.EmailRegex.maskEmail;

public class FileManager {

    /**
     *
     * method that take the filepath and return list of lines that exist in the file
     *
     * @param filePath of the input file
     * @return list of lines
     */

    public static List<String> readFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return lines;
    }

    // ==================================================================================================

    /**
     *
     * method that take list of lines and file and put the lines in the file
     *
     * @param filePath of the output file
     * @param lines that will be written in the file
     */

    public static void writeFileLines(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // ==================================================================================================

    /**
     *
     * method that take the file path and return the text that exist in the file
     *
     * @param filePath of the input file
     * @return text that in the file
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

    // ==================================================================================================

    /**
     *
     * method that take text and write it in the file of the file path
     *
     * @param filePath of the output file
     * @param content the text that will be written in the file
     */

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // ==================================================================================================



}
