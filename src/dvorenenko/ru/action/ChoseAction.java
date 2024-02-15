package dvorenenko.ru.action;

import dvorenenko.ru.input.InputFile;

import dvorenenko.ru.output.OutputFile;

import java.util.Scanner;

import static dvorenenko.ru.constant.Constant.CHOSE_ACTION;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_FILE;
import static dvorenenko.ru.constant.Constant.ADDRESS_OUTPUT_FILE;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;
import static dvorenenko.ru.constant.Constant.CHOSE_ACTION_ERROR;


public class ChoseAction {

    public void crypt() {
        int move = choseAction();

        if (ActionName.ENCRYPT.ordinal() == move) {
            operationEncrypt();
        } else if (ActionName.DECRYPT.ordinal() == move) {
            operationDecrypt();
        } else if (ActionName.BRUTE_FORCE.ordinal() == move) {
            operationBruteForce();
        } else if (ActionName.STATISTICAL_ANALYSIS.ordinal() == move) {
            operationStaticAnalyze();
        } else {
            repeat();
        }
    }

    private void repeat() {
        System.out.println(CHOSE_ACTION_ERROR);
        crypt();
    }

    private static void operationStaticAnalyze() {
        String inputText = getInputText();

        System.out.println(ADDRESS_OUTPUT_FILE);
        OutputFile output = new OutputFile();
        output.readAndCheckOutputPath();

        Action action = new Action();
        String outputText = action.staticAnalyzeText(inputText);

        output.writeFile(outputText);
    }

    private static void operationBruteForce() {
        String inputText = getInputText();

        System.out.println(ADDRESS_INPUT_EXAMPLE_FILE);
        InputFile inputExample = new InputFile();
        String inputTextExample = inputExample.checkNumberChar(inputExample.workWithInputFile());

        System.out.println(ADDRESS_OUTPUT_FILE);
        OutputFile output = new OutputFile();
        output.readAndCheckOutputPath();

        Action action = new Action();
        String outputText = action.bruteForceText(inputTextExample, inputText);

        output.writeFile(outputText);
    }

    private static void operationDecrypt() {
        String inputText = getInputText();

        System.out.println(ADDRESS_OUTPUT_FILE);
        OutputFile output = new OutputFile();
        output.readAndCheckOutputPath();

        Action action = new Action();
        String outputText = action.decryptText(inputText);

        output.writeFile(outputText);
    }

    private static void operationEncrypt() {
        String inputText = getInputText();

        System.out.println(ADDRESS_OUTPUT_FILE);
        OutputFile output = new OutputFile();
        output.readAndCheckOutputPath();

        Action action = new Action();
        String outputText = action.encryptText(inputText);

        output.writeFile(outputText);
    }

    private static String getInputText() {
        System.out.println(ADDRESS_INPUT_FILE);
        InputFile input = new InputFile();
        return input.workWithInputFile();
    }

    private int choseAction() {
        System.out.println(CHOSE_ACTION);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
