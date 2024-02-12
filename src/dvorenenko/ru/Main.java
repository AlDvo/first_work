package dvorenenko.ru;

import dvorenenko.ru.action.Action;
import dvorenenko.ru.action.CryptLogic;
import dvorenenko.ru.checks.CheckPath;
import dvorenenko.ru.input.Key;
import dvorenenko.ru.action.ChoseAction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CryptLogic cryptLogic = new CryptLogic();
        Key key = new Key();
        Scanner scan = new Scanner(System.in);
        Action action = new Action();
        CheckPath check = new CheckPath();
        ChoseAction choseAction = new ChoseAction(cryptLogic, key, action);
        choseAction.crypt(scan, check);
    }

}
