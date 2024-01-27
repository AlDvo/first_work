
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Укажите адресс фаила, откуда считываем текст ");
        String inputFileAddress = scan.nextLine();

        System.out.println("Укажите адресс фаила, куда записываем текст ");
        String outputFileAddress = scan.nextLine();

        System.out.println("Укажите ключ ");
        int key = scan.nextInt();

        Path inputPath = Path.of(inputFileAddress);
        Path outputPath = Path.of(outputFileAddress);

        String inputText;
        try {
            inputText = Files.readString(inputPath).toLowerCase();
        } catch (IOException e) {
            System.out.println("По указанному адрессу отсутсвует фаил для чтения");
            throw new RuntimeException(e);
        }

        String result = encrypt(inputText, key);
        //String result = decrypt(inputText, key);


        try {
            Files.writeString(outputPath, result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static String encrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j + key;
                if (inputText.charAt(i) == ALPHABET[j] && symbol < ALPHABET.length) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.charAt(i) == ALPHABET[j] && symbol >= ALPHABET.length) {
                    outputText.add(ALPHABET[symbol - ALPHABET.length]);
                    break;
                }
            }
        }
        return getStringRepresentation(outputText);
    }

    private static String decrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j - key;
                if (inputText.charAt(i) == ALPHABET[j] && symbol >= 0) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.charAt(i) == ALPHABET[j] && symbol < 0) {
                    outputText.add(ALPHABET[symbol + ALPHABET.length]);
                    break;
                }
            }
        }
        return getStringRepresentation(outputText);
    }


    private static String getStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}




