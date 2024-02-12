package dvorenenko.ru.action;

import dvorenenko.ru.checks.CheckPath;
import dvorenenko.ru.constant.Constant;
import dvorenenko.ru.input.InputFile;
import dvorenenko.ru.input.Key;
import dvorenenko.ru.output.OutputFile;

import java.util.Scanner;


public class ChoseAction {

    private final CryptLogic cryptLogic;
    private final Key key;
    private final Action action;

    public ChoseAction(CryptLogic cryptLogic, Key key, Action action) {
        this.cryptLogic = cryptLogic;
        this.key = key;
        this.action = action;
    }

    public void crypt(Scanner scan, CheckPath check) {
        int move = choseAction(scan);

        if (ActionName.ENCRYPT.ordinal() == move) {
            encrypt(action, scan, check);
        } else if (ActionName.DECRYPT.ordinal() == move) {
            decrypt(action, scan, check);
        } else if (ActionName.BRUTE_FORCE.ordinal() == move) {
            bruteForce(action, scan, check);
        } else if (ActionName.STATISTICAL_ANALYSIS.ordinal() == move) {
            statisticalAnalysis(action, scan, check);
        } else {
            System.out.println(Constant.CHOSE_ACTION_ERROR);
            crypt(scan, check);
        }
    }

    private void statisticalAnalysis(Action action, Scanner scan, CheckPath check) {
        System.out.println(Constant.ADDRESS_INPUT_FILE);
        String input = getInput(scan, check);

        String outputText = action.staticAnalyzeText(input, cryptLogic);

        System.out.println(Constant.ADDRESS_OUTPUT_FILE);
        getOutput(outputText, scan, check);
    }

    private void bruteForce(Action action, Scanner scan, CheckPath check) {
        System.out.println(Constant.ADDRESS_INPUT_FILE);
        String input = getInput(scan, check);

        System.out.println(Constant.ADDRESS_INPUT_EXAMPLE_FILE);
        String inputExample = getInputExampleForBruteForce(scan, check);

        String outputText = action.bruteForceText(inputExample, input, cryptLogic);

        System.out.println(Constant.ADDRESS_OUTPUT_FILE);
        getOutput(outputText, scan, check);
    }

    private void encrypt(Action action, Scanner scan, CheckPath check) {
        System.out.println(Constant.ADDRESS_INPUT_FILE);
        String input = getInput(scan, check);

        String outputText = action.encryptText(input, cryptLogic, key, scan);

        System.out.println(Constant.ADDRESS_OUTPUT_FILE);
        getOutput(outputText, scan, check);
    }

    private void decrypt(Action action, Scanner scan, CheckPath check) {
        System.out.println(Constant.ADDRESS_INPUT_FILE);
        String input = getInput(scan, check);

        String outputText = action.decryptText(input, cryptLogic, key, scan);

        System.out.println(Constant.ADDRESS_OUTPUT_FILE);
        getOutput(outputText, scan, check);
    }

    private void getOutput(String outputText, Scanner scan, CheckPath check) {
        OutputFile output = new OutputFile();
        output.writeFile(outputText, scan, check);
    }

    private int choseAction(Scanner scan) {
        System.out.println(Constant.CHOSE_ACTION);
        return scan.nextInt();
    }

    private String getInput(Scanner scan, CheckPath check) {
        InputFile input = new InputFile();
        input.readInputText(scan, check);
        return input.readInputText(scan, check);
    }

    private String getInputExampleForBruteForce(Scanner scan, CheckPath check) {
        InputFile input = new InputFile();
        String inputExample = input.readInputText(scan, check);
        return input.checkNumberChar(inputExample, scan, check);
    }
}
