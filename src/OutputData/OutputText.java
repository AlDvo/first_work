package OutputData;

import Cryption.Crypt;
import InputData.InputText;
import InputData.Key;


import java.util.Scanner;

public class OutputText {
    private String outputText;

    private String move;

    public void chooseAction() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите что делаем с фаилом: 'шифровать', 'расшифровать', 'brute Force'");
        move = scan.nextLine();
    }

    public void crypt(Crypt crypt, InputText inputText) {
        switch (move) {
            case "шифровать" -> {
                Key key = new Key();
                key.readKey();
                this.outputText = crypt.getStringRepresentation(crypt.encrypt(inputText, key.getKey()));
            }
            case "расшифровать" -> {
                Key key = new Key();
                key.readKey();
                this.outputText = crypt.getStringRepresentation(crypt.decrypt(inputText, key.getKey()));
            }
            case "brute Force" -> {
                this.outputText = crypt.getStringRepresentation(crypt.decrypt(inputText, crypt.bruteForce(inputText)));
            }
            case null, default -> System.out.println("название манипуляции с фаилом указано не корректно");
        }
    }


    public String getInputText() {
        return outputText;
    }
}
