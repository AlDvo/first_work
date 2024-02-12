package dvorenenko.ru.action;

import dvorenenko.ru.constant.Constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CryptLogic {


    public List<Character> encrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            changeCharWithKeyEncrypt(inputText, key, i, outputText);
        }
        return outputText;
    }

    public List<Character> decrypt(String inputText, int key) {
        List<Character> outputText = new ArrayList<>();

        for (int i = 0; i < inputText.length(); i++) {
            changeCharWithKeyDecrypt(inputText, key, i, outputText);
        }
        return outputText;
    }

    public int bruteForce(String exampleInputText, String decryptText) {
        int coincidence = Integer.MIN_VALUE;
        int key = 0;
        Set<String> oftenWordExampleText = findOftenWord(exampleInputText);

        for (int i = 0; i < Constant.ALPHABET.length; i++) {
            String cryptText = getStringRepresentation(decrypt(decryptText, i));
            Set<String> oftenWordCryptText = findOftenWord(cryptText);

            int tmpCoincidence = getCalculateMatchOftenWordBetweenText(oftenWordExampleText, oftenWordCryptText);

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

        for (int i = 0; i < Constant.ALPHABET.length; i++) {
            int tmpCoincidence = 0;
            tempOutputText = decrypt(inputText, i);

            tmpCoincidence = getCalculateMatchPointCommaInText(tempOutputText, tmpCoincidence);

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

    private Set<String> findOftenWord(String text) {
        List<String> example = new ArrayList<>(List.of(text.split(Constant.STRING_SPACE)));
        Set<String> statistic = new HashSet<>();
        for (String s : example) {
            if (s.length() < Constant.MIN_SYMBOLS_FOR_FIND_WORD && !s.equals(Constant.STRING_SPACE)) {
                statistic.add(s);
            }
        }
        return statistic;
    }

    private boolean checkCharWithKeyMoreLength(String inputText, int i, int j, int numberOfSymbol, int length) {
        return inputText.charAt(i) == Constant.ALPHABET[j] && numberOfSymbol >= length;
    }

    private boolean checkCharWithKeyLessLength(String inputText, int i, int j, int numberOfSymbol, int length) {
        return inputText.charAt(i) == Constant.ALPHABET[j] && numberOfSymbol < length;
    }

    private void changeCharWithKeyEncrypt(String inputText, int key, int i, List<Character> outputText) {
        for (int j = 0; j < Constant.ALPHABET.length; j++) {
            int numberOfSymbol = j + key;
            if (checkCharWithKeyLessLength(inputText, i, j, numberOfSymbol, Constant.ALPHABET.length)) {
                outputText.add(Constant.ALPHABET[numberOfSymbol]);
                break;
            } else if (checkCharWithKeyMoreLength(inputText, i, j, numberOfSymbol, Constant.ALPHABET.length)) {
                outputText.add(Constant.ALPHABET[numberOfSymbol - Constant.ALPHABET.length]);
                break;
            }
        }
    }

    private void changeCharWithKeyDecrypt(String inputText, int key, int i, List<Character> outputText) {
        for (int j = 0; j < Constant.ALPHABET.length; j++) {
            int numberOfSymbol = j - key;
            if (checkCharWithKeyMoreLength(inputText, i, j, numberOfSymbol, 0)) {
                outputText.add(Constant.ALPHABET[numberOfSymbol]);
                break;
            } else if (checkCharWithKeyLessLength(inputText, i, j, numberOfSymbol, 0)) {
                outputText.add(Constant.ALPHABET[numberOfSymbol + Constant.ALPHABET.length]);
                break;
            }
        }
    }

    private int getCalculateMatchOftenWordBetweenText(Set<String> oftenWordExampleText, Set<String> oftenWordCryptText) {
        int tmpCoincidence = 0;
        for (String example : oftenWordExampleText) {
            for (String crypt : oftenWordCryptText) {
                if (example.equals(crypt)) {
                    tmpCoincidence++;
                }
            }
        }
        return tmpCoincidence;
    }

    private int getCalculateMatchPointCommaInText(List<Character> tempOutputText, int tmpCoincidence) {

        for (int j = 1; j < tempOutputText.size(); j++) {
            if (tempOutputText.get(j) == Constant.CHAR_SPACE && tempOutputText.get(j - 1) == Constant.COMMA ||
                    tempOutputText.get(j) == Constant.CHAR_SPACE && tempOutputText.get(j - 1) == Constant.POINT) {
                tmpCoincidence++;
            }
        }
        return tmpCoincidence;
    }
}
