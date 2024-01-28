package InputData;

import java.io.IOException;
import java.nio.file.Files;

public class InputText {
    private String inputText;

    public void readInputText(InputFile input) {
        try {
            this.inputText = Files.readString(input.getPath()).toLowerCase();
        } catch (IOException e) {
            System.out.println("По указанному адрессу отсутсвует фаил для чтения");
            throw new RuntimeException(e);
        }
    }

    public String getInputText() {
        return inputText;
    }
}
