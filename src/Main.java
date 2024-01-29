import Cryption.Crypt;
import InputData.InputText;
import InputData.InputFile;
import OutputData.OutputFile;
import OutputData.OutputText;

public class Main {

    public static void main(String[] args) {
        InputFile input = new InputFile();
        input.readPath();
        input.checkFile();

        OutputFile output = new OutputFile();
        output.readPath();

        InputText inputText = new InputText();
        inputText.readInputText(input);

        Crypt crypt = new Crypt();

        OutputText outputText = new OutputText();
        outputText.chooseAction();
        outputText.crypt(crypt, inputText);

        output.writeFile(outputText);


    }

}





