package OutputData;

import Action.Action;
import CheckPath.CheckPath;
import MyException.ErrorExtensionException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static Constant.Constant.ERROR_EXTENSION_FILE;
import static Constant.Constant.REPEAT_ADDRESS_FILE;
import static Constant.Constant.ERROR_WRITE_FILE;


public class OutputFile {
    private Path path;

    public void readPath() {
        Scanner scan = new Scanner(System.in);
        String outputFileAddress = scan.nextLine();
        this.path = Path.of(outputFileAddress);

        CheckPath check = new CheckPath();
        try {
            check.checkPath(path);
        } catch (ErrorExtensionException e) {
            System.out.println(ERROR_EXTENSION_FILE);
            System.out.println(REPEAT_ADDRESS_FILE);
            readPath();
        }
    }

    public void writeFile(Action action) {
        try {
            Files.writeString(path, action.getInputText());
        } catch (IOException e) {
            System.out.println(ERROR_WRITE_FILE);
            throw new RuntimeException(e);
        }
    }
}
