package it.cspnet.gestionecarrellomvc.servizi;

public class UtenteInesistenteException extends Exception {

    public UtenteInesistenteException() {
    }

    public UtenteInesistenteException(String message) {
        super(message);
    }

    public UtenteInesistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtenteInesistenteException(Throwable cause) {
        super(cause);
    }

    public UtenteInesistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }  
}
