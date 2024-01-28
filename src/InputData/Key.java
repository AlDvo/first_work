package InputData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Key {
    private int key;

    public void readKey(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите ключ ");
        try {
            this.key = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Указанно не корректное значение ключа, используется значение по умолчанию '0' ");
        }
    }

    public int getKey() {
        return key;
    }
}
