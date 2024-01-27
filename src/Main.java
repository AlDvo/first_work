import Cryption.Crypt;
import InputData.*;
import OutputData.OutputFile;
import OutputData.OutputText;

public class Main {

    public static void main(String[] args) {
        InputFile input = new InputFile();
        input.checkFile();
        OutputFile output = new OutputFile();
        //output.checkFile();
        Key key = new Key();
        InputText inputText = new InputText(input);
        Crypt crypt = new Crypt(inputText,key);

        OutputText outputText = new OutputText();
        outputText.crypt(crypt);

        output.writeFile(outputText);


    }

}





