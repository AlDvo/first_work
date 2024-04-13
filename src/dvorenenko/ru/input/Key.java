package dvorenenko.ru.input;

import java.util.Scanner;

import static dvorenenko.ru.constant.Constant.ALPHABET;
import static dvorenenko.ru.constant.Constant.ENTER_KEY;

public class Key {
    public int workWithKey() {
        int key = readKey();
        return keyCheck(key);
    }

    private int readKey() {
        System.out.println(ENTER_KEY);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private int keyCheck(int key) {
        int result = key;
        if (Math.abs(key) > ALPHABET.length && key > 0) {
            do {
                result -= ALPHABET.length;
            } while (result > ALPHABET.length);
        } else if (Math.abs(key) > ALPHABET.length && key < 0) {
            do {
                result += ALPHABET.length;
            } while (result < ALPHABET.length);
        }
        return result;
    }
}
