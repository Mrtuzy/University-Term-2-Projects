package CENG112_HW1_G04;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileIO {

    public static String toLowerCase(String text) {
        return text.toLowerCase();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static List<String> tokenizeText(String text) {
        return Arrays.asList(text.split("\\s+"));
    }

    public static void readFile(Text<Word> text, Dictionary dictionary) {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "./src/text";
        File file = new File(filePath);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String lowerCaseText = toLowerCase(line);
                String cleanText = removePunctuation(lowerCaseText);
                List<String> words = tokenizeText(cleanText);

                for (String word : words) {
                    Word newWord = new Word(word);
                    text.add(newWord);
                    
                    if (!dictionary.contains(newWord)) {
                        dictionary.add(newWord);
                    }
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + e.getMessage());
        }
    }
}
