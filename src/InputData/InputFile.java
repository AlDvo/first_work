package InputData;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputFile {
    private String inputFileAddress;
    private Path path;

    public InputFile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите адресс фаила, откуда считываем текст ");
        this.inputFileAddress = scan.nextLine();
        this.path = Path.of(inputFileAddress);
    }

    public void checkFile()  {
        if(!Files.isRegularFile(path)){
            try {
                throw new FileNotFoundException("По указанному адрессу отсутсвует фаил для чтения");
            } catch (FileNotFoundException e) {
                System.out.println("По указанному адрессу отсутсвует фаил для чтения");
                throw new RuntimeException(e);
            }
        }
    }

    public Path getPath() {
        return path;
    }

}
