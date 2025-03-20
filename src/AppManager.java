import java.text.BreakIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import static problems.Problems_1_4_7_10_regex.*;
import static problems.Problems_2_5_8_11_regex.*;
import static problems.Problems_3_6_9_12_regex.*;
import static sensitive_information_regex.AddressRegex.maskAddress;
import static sensitive_information_regex.BankInfoRegex.*;
import static sensitive_information_regex.EgyptianNationalIDNumberRegex.maskNationalId;
import static sensitive_information_regex.EgyptianPhoneNumberRegex.maskPhoneNumber;
import static sensitive_information_regex.EmailRegex.maskEmail;

public class AppManager {

    /**
     *
     * run the app
     *
     * @param inputFilePath is the sample input file
     * @param outputFilePath is the sample output file
     */

    public static void run(String inputFilePath, String outputFilePath) {
        List<String> inputLines = FileManager.readFileLines(inputFilePath);
        if (inputLines == null) return;

        List<String> outputLines = processInput(inputLines);

        FileManager.writeFileLines(outputFilePath, outputLines);
    }

    // ==================================================================================================

    /**
     *
     * method that take the list of lines that was extracted from the sample input file
     *
     * @param inputLines that was extracted from the sample input file
     * @return list of output lines
     */

    private static List<String> processInput(List<String> inputLines) {
        List<String> outputLines = new ArrayList<>();
        int problemNumber = -1;
        String problem13File = null;

        for (String line : inputLines) {

            // Check if the line is a number

            if (line.matches("\\d+")) {
                int num = Integer.parseInt(line);

                // Ensure it's between 1 and 13
                if (num >= 1 && num <= 13) {
                    problemNumber = num;

                    // Don't add the number for problem 13
                    if (problemNumber != 13) {
                        outputLines.add(line);
                    }
                }
                continue;
            }

            // add X if the word "end" exits
            if ("end".equals(line)) {

                // Don't add "x" for problem 13
                if (problemNumber != 13) {
                    outputLines.add("x");
                }
                continue;
            }


            // if the problem is 13 that mean it is file and handle by different way
            if (problemNumber == 13) {
                problem13File = line;
            } else {
                // if the problem 1-12 call the method that take the number of the problem and the input will be the line
                outputLines.add(validateInput(problemNumber, line));
            }
        }

        // process the problem 13
        if (problem13File != null) {
            processProblem13(problem13File);
        }

        return outputLines;
    }

    // ==================================================================================================


    /**
     *
     * method to handle 1-12 problems
     *
     * @param problemNumber the number of the problem
     * @param input that will be validated
     * @return the output
     */

    private static String validateInput(int problemNumber, String input) {
        return switch (problemNumber) {
            case 1 -> isValidProblem1(input);
            case 2 -> isValidProblem2(input);
            case 3 -> isValidProblem3(input);
            case 4 -> isValidProblem4(input);
            case 5 -> isValidProblem5(input);
            case 6 -> isValidProblem6(input);
            case 7 -> isValidProblem7(input);
            case 8 -> isValidProblem8(input);
            case 9 -> isValidProblem9(input);
            case 10 -> isValidProblem10(input);
            case 11 -> isValidProblem11(input);
            case 12 -> isValidProblem12(input);
            default -> "Invalid";
        };
    }

    // ==================================================================================================

    /**
     *
     * method to handle problem 13
     *
     * @param inputFilePath the file that contains sensitive information
     */

    private static void processProblem13(String inputFilePath) {
        String content = FileManager.readFile(inputFilePath);
        if (content != null) {
            String maskedContent = processText(content);
            FileManager.writeFile(inputFilePath, maskedContent);
        }
    }

    // ==================================================================================================

    /**
     *
     * method that take the content of the input file of the problem 13 and return the output
     *
     * @param text of the inout file
     * @return the output of the problem
     */
    private static String processText(String text) {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(text);

        StringBuilder maskedText = new StringBuilder();

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

            maskedText.append(sentence);

            if (end - 1 >= 0 && text.charAt(end - 1) == '\n') {
                maskedText.append("\n");
            } else {
                maskedText.append(" ");
            }
        }

        return maskedText.toString();
    }

    // ==================================================================================================

}
