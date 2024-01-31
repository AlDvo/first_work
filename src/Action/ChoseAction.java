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

    private String move;

    private void choseAction() {
        System.out.println(CHOSE_ACTION);
        Scanner scan = new Scanner(System.in);
        move = scan.nextLine();
    }

    public void crypt() {
        choseAction();

        switch (move) {
            case "шифровать" -> {
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
            }
            case "расшифровать" -> {
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
            }
            case "brute force" -> {
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
            }
            case "статистический анализ" -> {
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
            }
            case null, default -> System.out.println(CHOSE_ACTION_ERROR);
        }
    }
}
