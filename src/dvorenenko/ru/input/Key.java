package dvorenenko.ru.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import static dvorenenko.ru.constant.Constant.ALPHABET;
import static dvorenenko.ru.constant.Constant.INCORRECT_KEY;
import static dvorenenko.ru.constant.Constant.ENTER_KEY;

public class Key {
    public int readKey(Scanner scan) {
        System.out.println(ENTER_KEY);

        try {
            return keyCheck(scan);
        } catch (InputMismatchException e) {
            System.out.println(INCORRECT_KEY);
            readKey(scan);
        }
        return 0;
    }

    private int keyCheck(Scanner scan) {
        int result = scan.nextInt();
        if (Math.abs(result) > ALPHABET.length && result > 0) {
            do {
                result -= ALPHABET.length;
            } while (result > ALPHABET.length);
        } else if (Math.abs(result) > ALPHABET.length && result < 0) {
            do {
                result += ALPHABET.length;
            } while (result < ALPHABET.length);
        }
        return result;
    }

}
