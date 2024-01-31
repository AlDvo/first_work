package Action;

import InputData.InputFile;
import InputData.Key;

public class Action {
    private String outputText;

    public void encryptText(InputFile inputText) {
        Crypt crypt = new Crypt();
        Key key = new Key();
        key.readKey();
        outputText = crypt.getStringRepresentation(crypt.encrypt(inputText, key.getKey()));
    }

    public void decryptText(InputFile inputText) {
        Crypt crypt = new Crypt();
        Key key = new Key();
        key.readKey();
        this.outputText = crypt.getStringRepresentation(crypt.decrypt(inputText, key.getKey()));
    }

    public void bruteForceText(InputFile exampleText, InputFile inputText) {
        Crypt crypt = new Crypt();
        int generatedKey = crypt.bruteForce(exampleText, inputText);
        this.outputText = crypt.getStringRepresentation(crypt.decrypt(inputText, generatedKey));
    }

    public void staticAnalyzeText(InputFile inputText) {
        Crypt crypt = new Crypt();
        int generatedKey = crypt.statisticAnalyze(inputText);
        this.outputText = crypt.getStringRepresentation(crypt.decrypt(inputText, generatedKey));
    }

    public String getInputText() {
        return outputText;
    }
}
