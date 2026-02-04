package exception;

import i18n.I18n;

public class FileResultException extends RuntimeException {
    public FileResultException() {
        super(I18n.get().text("error.result.file.not.exists"));
    }
}
