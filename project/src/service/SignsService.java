package service;

import static consts.Consts.*;

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
        for (char letter : ALPHABET)
            if (c == letter) {
                return true;
            }
        return false;
    }


    public char toCrypt(char c, int key, String language) {
        switch (language) {
            case "ru": {
                if (c >= ALPHABET_RUSSIAN.getFirst() && c <= ALPHABET_RUSSIAN.getLast()) {
                    int shift = ((c - ALPHABET_RUSSIAN.getFirst() + key) % ALPHABET_RUSSIAN.size());
                    if (shift < 0) shift += ALPHABET_RUSSIAN.size();
                    return (char) (ALPHABET_RUSSIAN.getFirst() + shift);
                }
                break;
            }
            case "en": {
                if (c >= ALPHABET_ENGLISH.getFirst() && c <= ALPHABET_ENGLISH.getLast()) {
                    int shift = ((c - ALPHABET_ENGLISH.getFirst() + key) % ALPHABET_ENGLISH.size());
                    if (shift < 0) shift += ALPHABET_ENGLISH.size();
                    return (char) (ALPHABET_ENGLISH.getFirst() + shift);
                }
                break;
            }
            default:
                break;
        }
        return c;
    }

}
