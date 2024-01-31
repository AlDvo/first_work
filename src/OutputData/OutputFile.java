package OutputData;

import Action.Action;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static constant.Constant.ERROR_WRITE_FILE;

public class OutputFile {
    private Path path;

    public void readPath() {
        Scanner scan = new Scanner(System.in);
        String outputFileAddress = scan.nextLine();
        this.path = Path.of(outputFileAddress);
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
