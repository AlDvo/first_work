package dvorenenko.ru.action;

import dvorenenko.ru.input.Key;

import java.util.Scanner;

public class Action {
    public String encryptText(String inputText, CryptLogic cryptLogic, Key key, Scanner scan) {
        return cryptLogic.getStringRepresentation(cryptLogic.encrypt(inputText, key.readKey(scan)));
    }

    public String decryptText(String inputText, CryptLogic cryptLogic, Key key, Scanner scan) {
        return cryptLogic.getStringRepresentation(cryptLogic.decrypt(inputText, key.readKey(scan)));
    }

    public String bruteForceText(String exampleText, String inputText, CryptLogic cryptLogic) {
        int generatedKey = cryptLogic.bruteForce(exampleText, inputText);
        return cryptLogic.getStringRepresentation(cryptLogic.decrypt(inputText, generatedKey));
    }

    public String staticAnalyzeText(String inputText, CryptLogic cryptLogic) {
        int generatedKey = cryptLogic.statisticAnalyze(inputText);
        return cryptLogic.getStringRepresentation(cryptLogic.decrypt(inputText, generatedKey));
    }
}
