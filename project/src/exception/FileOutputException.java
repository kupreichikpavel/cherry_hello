package exception;

import i18n.I18n;

public class FileOutputException extends RuntimeException {
    public FileOutputException() {
        super(I18n.get().text("error.output.file.not.exists"));
    }
}
