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

    public void writeFile(String inputText, Scanner scan, CheckPath check) {
        try {
            Files.writeString(readPath(scan, check), inputText);
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_FILE);
            throw new RuntimeException(e);
        }
    }

    private Path readPath(Scanner scan, CheckPath check) {
        String outputFileAddress = scan.nextLine();
        Path path = Path.of(outputFileAddress);

        try {
            check.checkPath(path);
            return path;
        } catch (ErrorExtensionException e) {
            System.out.println(ERROR_EXTENSION_FILE);
            System.out.println(REPEAT_ADDRESS_FILE);
            readPath(scan, check);
        }
        return null;
    }
}
