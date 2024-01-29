package Cryption;

import InputData.InputText;
import java.util.ArrayList;
import java.util.List;

public class Crypt {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', ')', '(', '\n'};

    public List<Character> encrypt(InputText inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.getInputText().length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j + key;
                if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol < ALPHABET.length) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol >= ALPHABET.length) {
                    outputText.add(ALPHABET[symbol - ALPHABET.length]);
                    break;
                }
            }
        }
        return outputText;
    }

    public List<Character> decrypt(InputText inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.getInputText().length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j - key;
                if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol >= 0) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol < 0) {
                    outputText.add(ALPHABET[symbol + ALPHABET.length]);
                    break;
                }
            }
        }
        return outputText;
    }

    public int bruteForce(InputText inputText) {
        int coincidence = Integer.MIN_VALUE;
        int key = 0;
        List<Character> tempOutputText;

        for (int i = 0; i < ALPHABET.length; i++) {
            int tmpCoincidence = 0;
            tempOutputText = decrypt(inputText, i);

            for (Character character : tempOutputText) {
                if (character == ' ') {
                    tmpCoincidence++;
                }
            }

            if (tmpCoincidence > coincidence) {
                coincidence = tmpCoincidence;
                key = i;
            }

        }
        return key;
    }

    public String getStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
