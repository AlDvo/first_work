package dvorenenko.ru.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dvorenenko.ru.constant.Constant.ALPHABET;

public class CryptLogic {

    public static final char CHAR_SPACE = ' ';
    public static final String SPACE = " ";
    public static final char CHAR_POINT = '.';
    public static final char CHAR_COMMA = ',';
    public static final int MIN_NUMBER_OF_ALPHABET_CHAR = 0;

    public List<Character> encrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = MIN_NUMBER_OF_ALPHABET_CHAR; i < inputText.length(); i++) {
            makeOutputEncryptText(inputText, key, i, outputText);
        }
        return outputText;
    }

    public List<Character> decrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = MIN_NUMBER_OF_ALPHABET_CHAR; i < inputText.length(); i++) {
            makeOutputDecryptText(inputText, key, i, outputText);
        }
        return outputText;
    }

    public int bruteForce(String exampleInputText, String decryptText) {
        int coincidence = Integer.MIN_VALUE;
        int key = MIN_NUMBER_OF_ALPHABET_CHAR;
        Set<String> oftenWordExampleText = findOftenWord(exampleInputText);

        for (int i = MIN_NUMBER_OF_ALPHABET_CHAR; i < ALPHABET.length; i++) {
            int tmpCoincidence = calculateCountMatchOftenWord(decryptText, i, oftenWordExampleText);

            if (tmpCoincidence > coincidence) {
                coincidence = tmpCoincidence;
                key = i;
            }
        }
        return key;
    }

    public int statisticAnalyze(String inputText) {
        int coincidence = Integer.MIN_VALUE;
        int key = MIN_NUMBER_OF_ALPHABET_CHAR;

        for (int i = MIN_NUMBER_OF_ALPHABET_CHAR; i < ALPHABET.length; i++) {
            int tmpCoincidence = calculateCountMatchChar(inputText, i);

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
    private int calculateCountMatchOftenWord(String decryptText, int i, Set<String> oftenWordExampleText) {
        int tmpCoincidence = MIN_NUMBER_OF_ALPHABET_CHAR;
        String cryptText = getStringRepresentation(decrypt(decryptText, i));
        Set<String> oftenWordCryptText = findOftenWord(cryptText);

        for (String example : oftenWordExampleText) {
            for (String crypt : oftenWordCryptText) {
                if (example.equals(crypt)) {
                    tmpCoincidence++;
                }
            }
        }
        return tmpCoincidence;
    }



    private int calculateCountMatchChar(String inputText, int i) {
        List<Character> tempOutputText;
        int tmpCoincidence = MIN_NUMBER_OF_ALPHABET_CHAR;
        tempOutputText = decrypt(inputText, i);

        for (int j = 1; j < tempOutputText.size(); j++) {
            if (tempOutputText.get(j) == CHAR_SPACE && tempOutputText.get(j - 1) == CHAR_COMMA ||
                    tempOutputText.get(j) == CHAR_SPACE && tempOutputText.get(j - 1) == CHAR_POINT) {
                tmpCoincidence++;
            }
        }
        return tmpCoincidence;
    }



    private void makeOutputEncryptText(String inputText, int key, int i, List<Character> outputText) {
        for (int j = MIN_NUMBER_OF_ALPHABET_CHAR; j < ALPHABET.length; j++) {
            int symbol = j + key;
            if (checkCharAndOffsetSymbolLessBorder(inputText, i, j, symbol, ALPHABET.length)) {
                outputText.add(ALPHABET[symbol]);
                break;
            } else if (checkCharAndOffsetSymbolMoreBorder(inputText, i, j, symbol, ALPHABET.length)) {
                outputText.add(ALPHABET[symbol - ALPHABET.length]);
                break;
            }
        }
    }

    private boolean checkCharAndOffsetSymbolMoreBorder(String inputText, int i, int j, int symbol, int borderAlphabet) {
        return inputText.charAt(i) == ALPHABET[j] && symbol >= borderAlphabet;
    }

    private boolean checkCharAndOffsetSymbolLessBorder(String inputText, int i, int j, int symbol, int borderAlphabet) {
        return inputText.charAt(i) == ALPHABET[j] && symbol < borderAlphabet;
    }


    private void makeOutputDecryptText(String inputText, int key, int i, List<Character> outputText) {
        for (int j = MIN_NUMBER_OF_ALPHABET_CHAR; j < ALPHABET.length; j++) {
            int symbol = j - key;
            if (checkCharAndOffsetSymbolMoreBorder(inputText, i, j, symbol, MIN_NUMBER_OF_ALPHABET_CHAR)) {
                outputText.add(ALPHABET[symbol]);
                break;
            } else if (checkCharAndOffsetSymbolLessBorder(inputText, i, j, symbol, MIN_NUMBER_OF_ALPHABET_CHAR)) {
                outputText.add(ALPHABET[symbol + ALPHABET.length]);
                break;
            }
        }
    }


    private Set<String> findOftenWord(String text) {
        List<String> example = new ArrayList<>(List.of(text.split(SPACE)));
        Set<String> statistic = new HashSet<>();
        for (String s : example) {
            if (s.length() < 4 && !s.equals(SPACE)) {
                statistic.add(s);
            }
        }
        return statistic;
    }
}
