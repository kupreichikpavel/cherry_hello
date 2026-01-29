package Service;

import static Consts.Consts.SIGNS;
import static Consts.Consts.ALPHABET_RUSSIAN;

public class SignsService {

    public boolean isSpecialSymbol(char c) {
        for (int i = 0; i < SIGNS.length; i++) {
            if (c == SIGNS[i] || (c >= '1' && c < '9')) {
                return true;
            }
        }
        return false;
    }
    public boolean isAlphabetSymbol(char c) {
        for (int i = 0; i < ALPHABET_RUSSIAN.length; i++) {
            if (c == ALPHABET_RUSSIAN[i]) {
                return true;
            }
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
