package OutputData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class OutputFile {
    private  String outputFileAddress;
    private Path path;
    public OutputFile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите адресс фаила, куда записываем текст ");
        this.outputFileAddress = scan.nextLine();
        this.path = Path.of(outputFileAddress);
    }

    public void checkFile()  {
        if(!Files.isDirectory(path)){
            try {
                throw new FileNotFoundException("По указанному адрессу отсутсвует директория");
            } catch (FileNotFoundException e) {
                System.out.println("По указанному адрессу отсутсвует директория");
                throw new RuntimeException(e);
            }
        }
    }

    public void writeFile(OutputText outputText){
        try {
            Files.writeString(path, outputText.getInputText());
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в фаил");
            throw new RuntimeException(e);
        }
    }


}
