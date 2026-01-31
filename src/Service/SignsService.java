package Service;

import static Consts.Consts.SIGNS;
import static Consts.Consts.ALPHABET_RUSSIAN;

public class SignsService {

    public boolean isSpecialSymbol(char c) {
        for (char sign : SIGNS) {
            if (sign == c) {
                return true;
            }
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAlphabetSymbol(char c) {
        for (char letter : ALPHABET_RUSSIAN)
            if (c == letter) {
                return true;
            }
        return false;
    }


    public char encryptCaesar(char c, int key) {
        if (c >= 'а' && c <= 'я') {
            int shift = ((c - 'а' + key) % 32);
            if (shift < 0) shift += 32;
            return (char) ('а' + shift);
        }
        return c;
    }

    public char decryptCaesar(char c, int key) {
        if (c >= 'а' && c <= 'я') {
            int shift = ((c - 'а' - key) % 32);
            if (shift < 0) shift += 32;
            return (char) ('а' + shift);
        }
        return c;
    }

}
