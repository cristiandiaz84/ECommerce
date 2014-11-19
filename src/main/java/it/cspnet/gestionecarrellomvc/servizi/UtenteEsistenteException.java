package it.cspnet.gestionecarrellomvc.servizi;

public class UtenteEsistenteException extends Exception {

    public UtenteEsistenteException() {
    }

    public UtenteEsistenteException(String message) {
        super(message);
    }

    public UtenteEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtenteEsistenteException(Throwable cause) {
        super(cause);
    }

    public UtenteEsistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
