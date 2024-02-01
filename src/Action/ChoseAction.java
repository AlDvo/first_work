package Action;

import InputData.InputFile;
import OutputData.OutputFile;

import java.util.Scanner;

import static Constant.Constant.CHOSE_ACTION;
import static Constant.Constant.ADDRESS_INPUT_FILE;
import static Constant.Constant.ADDRESS_OUTPUT_FILE;
import static Constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;
import static Constant.Constant.CHOSE_ACTION_ERROR;


public class ChoseAction {

    private int move;

    private void choseAction() {
        System.out.println(CHOSE_ACTION);
        Scanner scan = new Scanner(System.in);
        move = scan.nextInt();
    }

    public void crypt() {
        choseAction();

        if (ActionName.ENCRYPT.ordinal() == move) {
            System.out.println(ADDRESS_INPUT_FILE);
            InputFile input = new InputFile();
            input.readPath();
            input.checkFile();
            input.readInputText();

            System.out.println(ADDRESS_OUTPUT_FILE);
            OutputFile output = new OutputFile();
            output.readPath();

            Action action = new Action();
            action.encryptText(input);

            output.writeFile(action);
        } else if (ActionName.DECRYPT.ordinal() == move) {
            System.out.println(ADDRESS_INPUT_FILE);
            InputFile input = new InputFile();
            input.readPath();
            input.checkFile();
            input.readInputText();

            System.out.println(ADDRESS_OUTPUT_FILE);
            OutputFile output = new OutputFile();
            output.readPath();

            Action action = new Action();
            action.decryptText(input);

            output.writeFile(action);
        } else if (ActionName.BRUTE_FORCE.ordinal() == move) {
            System.out.println(ADDRESS_INPUT_FILE);
            InputFile input = new InputFile();
            input.readPath();
            input.checkFile();
            input.readInputText();

            System.out.println(ADDRESS_INPUT_EXAMPLE_FILE);
            InputFile inputExample = new InputFile();
            inputExample.readPath();
            inputExample.checkFile();
            inputExample.readInputText();
            inputExample.checkNumberChar();

            System.out.println(ADDRESS_OUTPUT_FILE);
            OutputFile output = new OutputFile();
            output.readPath();

            Action action = new Action();
            action.bruteForceText(inputExample, input);

            output.writeFile(action);
        } else if (ActionName.STATISTICAL_ANALYSIS.ordinal() == move) {
            System.out.println(ADDRESS_INPUT_FILE);
            InputFile input = new InputFile();
            input.readPath();
            input.checkFile();
            input.readInputText();

            System.out.println(ADDRESS_OUTPUT_FILE);
            OutputFile output = new OutputFile();
            output.readPath();

            Action action = new Action();
            action.staticAnalyzeText(input);

            output.writeFile(action);
        } else {
            System.out.println(CHOSE_ACTION_ERROR);
            crypt();
        }
    }
}
