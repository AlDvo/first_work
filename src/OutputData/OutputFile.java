package OutputData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class OutputFile {
    private  String outputFileAddress;
    private Path path;

    public void readPath(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите адресс фаила, откуда считываем текст ");
        outputFileAddress = scan.nextLine();
        this.path = Path.of(outputFileAddress);
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
