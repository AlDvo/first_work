package dvorenenko.ru;
import dvorenenko.ru.action.Action;
import dvorenenko.ru.action.ChoseAction;
import dvorenenko.ru.action.CryptLogic;
import dvorenenko.ru.input.InputFile;
import dvorenenko.ru.input.Key;
import dvorenenko.ru.output.OutputFile;

public class Main {

    public static void main(String[] args) {
        CryptLogic cryptLogic = new CryptLogic();
        Key key = new Key();
        Action action = new Action();
        OutputFile output = new OutputFile();
        InputFile inputExample = new InputFile();

        ChoseAction choseAction = new ChoseAction(cryptLogic, key, action, output, inputExample);
        choseAction.crypt();
    }
}
