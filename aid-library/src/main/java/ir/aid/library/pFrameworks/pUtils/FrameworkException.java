package ir.aid.library.pFrameworks.pUtils;

public class FrameworkException extends Exception {

    private static String DEVELOPER = "محمد علی ریاضتی";

    public FrameworkException() {
        super();
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameworkException(Throwable cause) {
        super(cause);
    }

}
