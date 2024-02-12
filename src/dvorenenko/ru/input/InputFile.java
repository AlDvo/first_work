package dvorenenko.ru.input;

import dvorenenko.ru.constant.Constant;
import dvorenenko.ru.exception.ErrorExtensionException;
import dvorenenko.ru.exception.FileMissingException;
import dvorenenko.ru.checks.CheckPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class InputFile {

    public static final int MIN_LENGTH_EXAMPLE_TEXT = 1000;

    public String readInputText(Scanner scan, CheckPath check) {
        try {
            return Files.readString(readPath(scan, check)).toLowerCase();
        } catch (IOException e) {
            System.out.println(Constant.ADDRESS_INPUT_FILE_NOT_FOUND);
            System.out.println(Constant.REPEAT_ADDRESS_FILE);
            wayFromPathToTextWithCheck(scan, check);
        }
        return null;
    }

    public String checkNumberChar(String inputText, Scanner scan, CheckPath check) {
        while (inputText.length() < MIN_LENGTH_EXAMPLE_TEXT) {
            System.out.println(Constant.STRING_NOT_SUITABLE);
            System.out.println(Constant.ADDRESS_INPUT_EXAMPLE_FILE);
            wayFromPathToTextWithCheck(scan, check);
            checkNumberChar(inputText, scan, check);
        }
        return inputText;
    }

    private void wayFromPathToTextWithCheck(Scanner scan, CheckPath check) {
        readPath(scan, check);
        try {
            checkFile(scan, check);
        } catch (FileMissingException e) {
            throw new RuntimeException(e);
        }
        readInputText(scan, check);
    }

    private Path readPath(Scanner scan, CheckPath check) {
        String inputFileAddress = scan.nextLine();
        Path path = Path.of(inputFileAddress);

        try {
            check.checkPath(path);
            return path;
        } catch (ErrorExtensionException e) {
            System.out.println(Constant.ERROR_EXTENSION_FILE);
            System.out.println(Constant.REPEAT_ADDRESS_FILE);
            wayFromPathToTextWithCheck(scan, check);
        }
        return null;
    }

    private void checkFile(Scanner scan, CheckPath check) throws FileMissingException {
        if (!Files.isRegularFile(readPath(scan, check))) {
            System.out.println(Constant.ADDRESS_INPUT_FILE_NOT_FOUND);
            System.out.println(Constant.REPEAT_ADDRESS_FILE);
            wayFromPathToTextWithCheck(scan, check);
        }
    }
}
