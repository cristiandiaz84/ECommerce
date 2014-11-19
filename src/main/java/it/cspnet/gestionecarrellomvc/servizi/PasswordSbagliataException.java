package it.cspnet.gestionecarrellomvc.servizi;

public class PasswordSbagliataException extends Exception {

    public PasswordSbagliataException() {
    }

    public PasswordSbagliataException(String message) {
        super(message);
    }

    public PasswordSbagliataException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordSbagliataException(Throwable cause) {
        super(cause);
    }

    public PasswordSbagliataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
