package dvorenenko.ru.input;

import dvorenenko.ru.checks.CheckPath;
import dvorenenko.ru.exception.ErrorExtensionException;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


import static dvorenenko.ru.constant.Constant.ERROR_EXTENSION_FILE;
import static dvorenenko.ru.constant.Constant.REPEAT_ADDRESS_FILE;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_FILE_NOT_FOUND;
import static dvorenenko.ru.constant.Constant.STRING_NOT_SUITABLE;
import static dvorenenko.ru.constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;


public class InputFile {
    private Path path;

    public String workWithInputFile() {
        readPath();
        checkExtension();
        checkFile();
        return readInputText();
    }

    private void readPath() {
        Scanner scan = new Scanner(System.in);
        String inputFileAddress = scan.nextLine();
        this.path = Path.of(inputFileAddress);
    }

    private void checkExtension() {
        CheckPath check = new CheckPath();
        try {
            check.checkPath(path);
        } catch (ErrorExtensionException e) {
            System.out.println(ERROR_EXTENSION_FILE);
            System.out.println(REPEAT_ADDRESS_FILE);
            workWithInputFile();
        }
    }

    private void checkFile() {
        if (!Files.isRegularFile(path)) {
            System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
            System.out.println(REPEAT_ADDRESS_FILE);
            workWithInputFile();
        }
    }

    private String readInputText() {
        try {
            return Files.readString(path).toLowerCase();
        } catch (IOException e) {
            System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
            System.out.println(REPEAT_ADDRESS_FILE);
            workWithInputFile();
        }
        return "";
    }

    public String checkNumberChar(String inputText) {
        while (inputText.length() < 1000) {
            System.out.println(STRING_NOT_SUITABLE);
            System.out.println(ADDRESS_INPUT_EXAMPLE_FILE);
            inputText = workWithInputFile();
        }
        return inputText;
    }
}
