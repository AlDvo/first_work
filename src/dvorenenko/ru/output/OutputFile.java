package dvorenenko.ru.output;

import dvorenenko.ru.checks.CheckPath;
import dvorenenko.ru.exception.ErrorExtensionException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static dvorenenko.ru.constant.Constant.ERROR_EXTENSION_FILE;
import static dvorenenko.ru.constant.Constant.REPEAT_ADDRESS_FILE;
import static dvorenenko.ru.constant.Constant.ERROR_WRITE_FILE;


public class OutputFile {
    private Path path;

    public void readAndCheckOutputPath(){
        readPath();
        checkOutputPath();
    }

    private void readPath() {
        Scanner scan = new Scanner(System.in);
        String outputFileAddress = scan.nextLine();
        this.path = Path.of(outputFileAddress);
    }

    private void checkOutputPath() {
        CheckPath check = new CheckPath();
        try {
            check.checkPath(path);
        } catch (ErrorExtensionException e) {
            System.out.println(ERROR_EXTENSION_FILE);
            System.out.println(REPEAT_ADDRESS_FILE);
            readPath();
        }
    }

    public void writeFile(String action) {
        try {
            Files.writeString(path, action);
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_FILE);
            throw new RuntimeException(e);
        }
    }
}
