package InputData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static constant.Constant.ADDRESS_INPUT_FILE_NOT_FOUND;
import static constant.Constant.STRING_NOT_SUITABLE;
import static constant.Constant.ADDRESS_INPUT_EXAMPLE_FILE;

public class InputFile {
    private Path path;
    private String inputText;

    public void readPath() {
        Scanner scan = new Scanner(System.in);
        String inputFileAddress = scan.nextLine();
        this.path = Path.of(inputFileAddress);
    }

    public void checkFile() {
        if (!Files.isRegularFile(path)) {
            try {
                throw new FileNotFoundException(ADDRESS_INPUT_FILE_NOT_FOUND);
            } catch (FileNotFoundException e) {
                System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
                throw new RuntimeException(e);
            }
        }
    }

    public void readInputText() {
        try {
            this.inputText = Files.readString(path).toLowerCase();
        } catch (IOException e) {
            System.out.println(ADDRESS_INPUT_FILE_NOT_FOUND);
            throw new RuntimeException(e);
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
