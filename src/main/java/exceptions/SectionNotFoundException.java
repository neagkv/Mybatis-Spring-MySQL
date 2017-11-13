package exceptions;

public class SectionNotFoundException  extends Exception {

    String message;
    int status_code;

    public SectionNotFoundException(String message, int status_code) {
        this.message = message;
        this.status_code = status_code;
    }

    public SectionNotFoundException(String message, String message1, int status_code) {
        super(message);
        this.message = message1;
        this.status_code = status_code;
    }

    public SectionNotFoundException(String message, Throwable cause, String message1, int status_code) {
        super(message, cause);
        this.message = message1;
        this.status_code = status_code;
    }

    public SectionNotFoundException(Throwable cause, String message, int status_code) {
        super(cause);
        this.message = message;
        this.status_code = status_code;
    }

    public SectionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, int status_code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.status_code = status_code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
