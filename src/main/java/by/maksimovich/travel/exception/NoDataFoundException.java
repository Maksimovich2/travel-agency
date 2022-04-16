package by.maksimovich.travel.exception;

/**
 * @author Maksim Maksimovich
 * @created 16/04/2022 - 12:02
 */
public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException() {
    }

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataFoundException(Throwable cause) {
        super(cause);
    }
}
