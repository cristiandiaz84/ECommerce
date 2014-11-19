package it.cspnet.gestionecarrellomvc.servizi;


import it.cspnet.gestionecarrellomvc.model.CarrelloSpesa;
import it.cspnet.gestionecarrellomvc.model.Ordine;
import it.cspnet.gestionecarrellomvc.model.Prodotto;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ServiziEcommerce {
    
    public Utenti creaUtente(Utenti utente)throws UtenteEsistenteException;
    
    public Utenti listaUtenti(String userName, String password)throws UtenteInesistenteException, PasswordSbagliataException, Exception;
    
    public Collection<Prodotto> listaProdotti();

    public Prodotto cercaProdotto(int idProdotto);

    public void acquista(CarrelloSpesa carrello, Utenti utenti);

    public Collection<Ordine> listaOrdini(String userName);
    
    public void eliminaOrdine(int idOrdine);

    public float valoreOrdini(Date data);

    public Ordine cercaOrdine(int idOrdine);

//    public Utenti listaUtenti(Utenti utente)throws UtenteInesistenteException, PasswordSbagliataException, Exception;

    public List<Prodotto> cercaProdotti(String nome);



}
