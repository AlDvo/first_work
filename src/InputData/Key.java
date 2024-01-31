package InputData;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Constant.Constant.ALPHABET;
import static Constant.Constant.INCORRECT_KEY;
import static Constant.Constant.ENTER_KEY;

public class Key {
    private int key;

    public void readKey() {
        System.out.println(ENTER_KEY);
        Scanner scan = new Scanner(System.in);

        try {
            this.key = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INCORRECT_KEY);
            readKey();
        }
    }

    public int keyCheck() {
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

    public int getKey() {
        return keyCheck();
    }
}
