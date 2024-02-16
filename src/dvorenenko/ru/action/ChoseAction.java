package dvorenenko.ru.action;

import dvorenenko.ru.input.InputFile;

import dvorenenko.ru.input.Key;
import dvorenenko.ru.output.OutputFile;

import java.util.Scanner;

import static dvorenenko.ru.constant.Constant.CHOSE_ACTION;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_FILE;
import static dvorenenko.ru.constant.Constant.ADDRESS_OUTPUT_FILE;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;
import static dvorenenko.ru.constant.Constant.CHOSE_ACTION_ERROR;


public class ChoseAction {

    private final CryptLogic cryptLogic;
    private final Key key;
    private final Action action;
    private final OutputFile output;
    private final InputFile input;


    public ChoseAction(CryptLogic cryptLogic, Key key, Action action, OutputFile output, InputFile input) {
        this.cryptLogic = cryptLogic;
        this.key = key;
        this.action = action;
        this.output = output;
        this.input = input;
    }

    public void crypt() {
        int move = choseAction();

        if (ActionName.ENCRYPT.ordinal() == move) {
            operationEncrypt(cryptLogic, key, action, output, input);
        } else if (ActionName.DECRYPT.ordinal() == move) {
            operationDecrypt(cryptLogic, key, action, output, input);
        } else if (ActionName.BRUTE_FORCE.ordinal() == move) {
            operationBruteForce(cryptLogic, action, output, input, input);
        } else if (ActionName.STATISTICAL_ANALYSIS.ordinal() == move) {
            operationStaticAnalyze(cryptLogic, action, output, input);
        } else {
            repeat();
        }
    }

    private void repeat() {
        System.out.println(CHOSE_ACTION_ERROR);
        crypt();
    }

    private static void operationStaticAnalyze(CryptLogic cryptLogic, Action action, OutputFile output, InputFile input) {
        String inputText = getInputText(input);

        System.out.println(ADDRESS_OUTPUT_FILE);
        output.readAndCheckOutputPath();

        String outputText = action.staticAnalyzeText(inputText, cryptLogic);
        output.writeFile(outputText);
    }

    private static void operationBruteForce(CryptLogic cryptLogic, Action action, OutputFile output, InputFile input, InputFile inputExample) {
        String inputText = getInputText(input);

        System.out.println(ADDRESS_INPUT_EXAMPLE_FILE);
        String inputTextExample = inputExample.checkNumberChar(inputExample.workWithInputFile());

        System.out.println(ADDRESS_OUTPUT_FILE);
        output.readAndCheckOutputPath();

        String outputText = action.bruteForceText(inputTextExample, inputText, cryptLogic);
        output.writeFile(outputText);
    }

    private static void operationDecrypt(CryptLogic cryptLogic, Key key, Action action, OutputFile output, InputFile input) {
        String inputText = getInputText(input);

        System.out.println(ADDRESS_OUTPUT_FILE);
        output.readAndCheckOutputPath();

        String outputText = action.decryptText(inputText, cryptLogic, key);
        output.writeFile(outputText);
    }

    private static void operationEncrypt(CryptLogic cryptLogic, Key key, Action action, OutputFile output, InputFile input) {
        String inputText = getInputText(input);

        System.out.println(ADDRESS_OUTPUT_FILE);
        output.readAndCheckOutputPath();

        String outputText = action.encryptText(inputText, cryptLogic, key);
        output.writeFile(outputText);
    }

    private static String getInputText(InputFile input) {
        System.out.println(ADDRESS_INPUT_FILE);
        return input.workWithInputFile();
    }

    private int choseAction() {
        Scanner scan = new Scanner(System.in);
        System.out.println(CHOSE_ACTION);
        return scan.nextInt();
    }
}
