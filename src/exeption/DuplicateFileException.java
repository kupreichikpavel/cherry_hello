package exeption;

public class DuplicateFileException extends  Exception{
    public DuplicateFileException(String message) {
        super(message);
    }
}
