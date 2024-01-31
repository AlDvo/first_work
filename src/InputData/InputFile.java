package InputData;

import CheckPath.CheckPath;
import MyException.ErrorExtensionException;
import MyException.FileMissingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static Constant.Constant.ERROR_EXTENSION_FILE;
import static Constant.Constant.REPEAT_ADDRESS_FILE;
import static Constant.Constant.ADDRESS_INPUT_FILE_NOT_FOUND;
import static Constant.Constant.STRING_NOT_SUITABLE;
import static Constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;


public class InputFile {
    private Path path;
    private String inputText;

    public void readPath() {
        Scanner scan = new Scanner(System.in);
        String inputFileAddress = scan.nextLine();
        this.path = Path.of(inputFileAddress);

        CheckPath check = new CheckPath();
        try {
            check.checkPath(path);
        } catch (ErrorExtensionException e) {
            System.out.println(ERROR_EXTENSION_FILE);
            System.out.println(REPEAT_ADDRESS_FILE);
            readPath();
            checkFile();
            readInputText();
        }
    }

    public void checkFile() {
        if (!Files.isRegularFile(path)) {
            try {
                throw new FileMissingException(ADDRESS_INPUT_FILE_NOT_FOUND);
            } catch (Exception e) {
                System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
                System.out.println(REPEAT_ADDRESS_FILE);
                readPath();
                checkFile();
                readInputText();
            }
        }
    }

    public void readInputText() {
        try {
            this.inputText = Files.readString(path).toLowerCase();
        } catch (IOException e) {
            System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
            System.out.println(REPEAT_ADDRESS_FILE);
            readPath();
            checkFile();
            readInputText();
        }
    }

    public void checkNumberChar(){
        while(inputText.length() < 1000){
            System.out.println(STRING_NOT_SUITABLE);
            System.out.println(ADDRESS_INPUT_EXAMPLE_FILE);
            readPath();
            checkFile();
            readInputText();
            checkNumberChar();
        }
    }

    public String getInputText() {
        return inputText;
    }

}
