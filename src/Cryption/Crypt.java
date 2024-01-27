package Cryption;

import InputData.InputText;
import InputData.Key;
import java.util.ArrayList;
import java.util.List;

public class Crypt {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ',')','(','\n'};
    private InputText inputText;
    private Key key;

    public  Crypt(InputText inputText, Key key){
        this.inputText = inputText;
        this.key = key;
    }

    public String encrypt() {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.getInputText().length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j + key.getKey();
                if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol < ALPHABET.length) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol >= ALPHABET.length) {
                    outputText.add(ALPHABET[symbol - ALPHABET.length]);
                    break;
                }
            }
        }
        return getStringRepresentation(outputText);
    }

    public String decrypt() {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.getInputText().length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                int symbol = j - key.getKey();
                if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol >= 0) {
                    outputText.add(ALPHABET[symbol]);
                    break;
                } else if (inputText.getInputText().charAt(i) == ALPHABET[j] && symbol < 0) {
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
