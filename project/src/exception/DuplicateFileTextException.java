package exception;

import i18n.I18n;

public class DuplicateFileTextException extends Exception {
    public DuplicateFileTextException() {
        super(I18n.get().text("error.duplicate.files"));
    }
}
