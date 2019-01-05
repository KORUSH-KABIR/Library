package ir.aid.library.Frameworks.utils;

public class FrameworkException extends Throwable {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

}
