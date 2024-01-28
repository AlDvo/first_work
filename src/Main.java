import Cryption.Crypt;
import InputData.InputText;
import InputData.InputFile;
import InputData.Key;
import OutputData.OutputFile;
import OutputData.OutputText;

public class Main {

    public static void main(String[] args) {
        InputFile input = new InputFile();
        input.readPath();
        input.checkFile();

        OutputFile output = new OutputFile();
        output.readPath();

        Key key = new Key();
        key.readKey();

        InputText inputText = new InputText();
        inputText.readInputText(input);

        Crypt crypt = new Crypt(inputText,key);

        OutputText outputText = new OutputText();
        outputText.chooseAction();
        outputText.crypt(crypt);

        output.writeFile(outputText);


    }

}





