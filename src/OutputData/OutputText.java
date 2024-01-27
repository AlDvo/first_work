package OutputData;

import Cryption.Crypt;


import java.util.Scanner;

public class OutputText {
    private String outputText;

    private String move;

    public OutputText() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите что делаем с фаилом: 'шифровать' или 'расшифровать'");
        move = scan.nextLine();
    }

    public void crypt(Crypt crypt) {
        if ("шифровать".equals(move)) {
            this.outputText = crypt.encrypt();
        } else if ("расшифровать".equals(move)) {
            this.outputText = crypt.decrypt();
        } else {
            System.out.println("название манипуляции с фаилом указано не корректно");
        }
    }


    public String getInputText() {
        return outputText;
    }
}
