import static sensitive_information_regex.AddressRegex.*;

public class App {

    public static void main(String[] args) {
        String inputFilePath = "src/input.txt";
        String outputFilePath = "src/output.txt";

        String content = FileManager.readFile(inputFilePath);
        if (content != null) {
            String maskedContent = FileManager.processText(content);
            FileManager.writeFile(outputFilePath, maskedContent);
        }
    }
}
