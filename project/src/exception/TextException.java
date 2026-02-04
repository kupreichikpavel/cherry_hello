package exception;

import i18n.I18n;

public class TextException extends RuntimeException {
    public TextException() {
        super(I18n.get().text("error.not.enough.text"));
    }
}