package dvorenenko.ru.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dvorenenko.ru.constant.Constant.ALPHABET;

public class Crypt {
    public List<Character> encrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            makeOutputEncryptText(inputText, key, i, outputText);
        }
        return outputText;
    }

    public List<Character> decrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            makeOutputDecryptText(inputText, key, i, outputText);
        }
        return outputText;
    }

    public int bruteForce(String exampleInputText, String decryptText) {
        int coincidence = Integer.MIN_VALUE;
        int key = 0;
        Set<String> oftenWordExampleText = findOftenWord(exampleInputText);

        for (int i = 0; i < ALPHABET.length; i++) {
            int tmpCoincidence = 0;
            String cryptText = getStringRepresentation(decrypt(decryptText, i));
            Set<String> oftenWordCryptText = findOftenWord(cryptText);

            for (String example : oftenWordExampleText) {
                for (String crypt : oftenWordCryptText) {
                    if (example.equals(crypt)) {
                        tmpCoincidence++;
                    }
                }
            }

            if (tmpCoincidence > coincidence) {
                coincidence = tmpCoincidence;
                key = i;
            }
        }
        return key;
    }

    public int statisticAnalyze(String inputText) {
        int coincidence = Integer.MIN_VALUE;
        int key = 0;
        List<Character> tempOutputText;

        for (int i = 0; i < ALPHABET.length; i++) {
            int tmpCoincidence = 0;
            tempOutputText = decrypt(inputText, i);

            for (int j = 1; j < tempOutputText.size(); j++) {
                if (tempOutputText.get(j) == ' ' && tempOutputText.get(j - 1) == ',' ||
                        tempOutputText.get(j) == ' ' && tempOutputText.get(j - 1) == '.') {
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

    private static void makeOutputEncryptText(String inputText, int key, int i, List<Character> outputText) {
        for (int j = 0; j < ALPHABET.length; j++) {
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

    private static boolean checkCharAndOffsetSymbolMoreBorder(String inputText, int i, int j, int symbol, int borderAlphabet) {
        return inputText.charAt(i) == ALPHABET[j] && symbol >= borderAlphabet;
    }

    private static boolean checkCharAndOffsetSymbolLessBorder(String inputText, int i, int j, int symbol, int borderAlphabet) {
        return inputText.charAt(i) == ALPHABET[j] && symbol < borderAlphabet;
    }


    private static void makeOutputDecryptText(String inputText, int key, int i, List<Character> outputText) {
        for (int j = 0; j < ALPHABET.length; j++) {
            int symbol = j - key;
            if (checkCharAndOffsetSymbolMoreBorder(inputText, i, j, symbol, 0)) {
                outputText.add(ALPHABET[symbol]);
                break;
            } else if (checkCharAndOffsetSymbolLessBorder(inputText, i, j, symbol, 0)) {
                outputText.add(ALPHABET[symbol + ALPHABET.length]);
                break;
            }
        }
    }


    private Set<String> findOftenWord(String text) {
        List<String> example = new ArrayList<>(List.of(text.split(" ")));
        Set<String> statistic = new HashSet<>();
        for (String s : example) {
            if (s.length() < 4 && !s.equals(" ")) {
                statistic.add(s);
            }
        }
        return statistic;
    }
}
