package exception;

import i18n.I18n;

public class FileInputExeception extends RuntimeException {
    public FileInputExeception() {
        super(I18n.get().text("error.input.file.not.exists"));
    }
}