package InputData;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constant.Constant.ALPHABET;
import static constant.Constant.INCORRECT_KEY;
import static constant.Constant.ENTER_KEY;

public class Key {
    private int key;

    public void readKey() {
        System.out.println(ENTER_KEY);
        Scanner scan = new Scanner(System.in);

        try {
            this.key = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INCORRECT_KEY);
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
