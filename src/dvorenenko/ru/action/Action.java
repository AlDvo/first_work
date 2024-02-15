package dvorenenko.ru.action;

import dvorenenko.ru.input.Key;

public class Action {

    public String encryptText(String inputText) {
        Crypt crypt = new Crypt();
        Key key = new Key();
        return crypt.getStringRepresentation(crypt.encrypt(inputText, key.workWithKey()));

    }

    public String decryptText(String inputText) {
        Crypt crypt = new Crypt();
        Key key = new Key();
        return crypt.getStringRepresentation(crypt.decrypt(inputText, key.workWithKey()));
    }

    public String bruteForceText(String exampleText, String inputText) {
        Crypt crypt = new Crypt();
        int generatedKey = crypt.bruteForce(exampleText, inputText);
        return crypt.getStringRepresentation(crypt.decrypt(inputText, generatedKey));
    }

    public String staticAnalyzeText(String inputText) {
        Crypt crypt = new Crypt();
        int generatedKey = crypt.statisticAnalyze(inputText);
        return crypt.getStringRepresentation(crypt.decrypt(inputText, generatedKey));
    }
}
