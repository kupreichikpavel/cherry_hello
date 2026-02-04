package exception;

import i18n.I18n;

public class UnsupportedFileException extends RuntimeException {
    public UnsupportedFileException() {
        super(I18n.get().text("error.file.modify.forbidden"));
    }
}
