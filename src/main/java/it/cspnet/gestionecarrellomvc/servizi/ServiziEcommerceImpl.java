package it.cspnet.gestionecarrellomvc.servizi;


import it.cspnet.gestionecarrellomvc.model.CarrelloSpesa;
import it.cspnet.gestionecarrellomvc.model.LineaOrdine;
import it.cspnet.gestionecarrellomvc.model.Ordine;
import it.cspnet.gestionecarrellomvc.model.Prodotto;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import it.cspnet.gestionecarrellomvc.model.VoceCarrello;
import it.cspnet.gestionecarrellomvc.repository.LineeOrdineDao;
import it.cspnet.gestionecarrellomvc.repository.OrdineDao;
import it.cspnet.gestionecarrellomvc.repository.ProdottoDao;
import it.cspnet.gestionecarrellomvc.repository.UtentiDao;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;

@Service("servizi")
@Transactional
public class ServiziEcommerceImpl implements ServiziEcommerce {

    @Autowired
    private ProdottoDao prodottoDao;
    @Autowired
    private OrdineDao ordineDao;
    @Autowired
    private LineeOrdineDao lineeOrdineDao;
    @Autowired
    private UtentiDao utentiDao;


    public void setProdottoDao(ProdottoDao prodottoDao) {
        this.prodottoDao = prodottoDao;
    }
    
    public void setOrdineDao(OrdineDao ordineDao) {
        this.ordineDao = ordineDao;
    }

    public void setLineeOrdineDao(LineeOrdineDao lineeOrdineDao) {
        this.lineeOrdineDao = lineeOrdineDao;
    }

    public void setUtentiDao(UtentiDao utentiDao) {
        this.utentiDao = utentiDao;
    }

    @Override
    public Utenti creaUtente(Utenti utente)throws UtenteEsistenteException {
        if(utentiDao.exists(utente.getUserName())){
            throw new UtenteEsistenteException();
        }    
        return utentiDao.save(utente);
    }

    @Override
    public Utenti listaUtenti(String userName, String password)throws UtenteInesistenteException, PasswordSbagliataException, Exception{
        try{
            Utenti utente = utentiDao.findOne(userName);
            if(utente.getUserName()==null){
                throw new UtenteInesistenteException();
            }
            if (!password.equals(utente.getPassword())) {
                throw new PasswordSbagliataException();
            }
            return utente;
        }catch (EmptyResultDataAccessException ex){
            throw new UtenteInesistenteException();
        }
    }

    @Override
    public Prodotto cercaProdotto(int idProdotto) {
        return prodottoDao.findOne(idProdotto);
    }

    @Override
    public Collection<Prodotto> listaProdotti() {
        return prodottoDao.findAll();
    }

    @Override
    public void acquista(CarrelloSpesa carrello, Utenti utenti) {
        Ordine ordine = ordineDao.save(new Ordine(new Date(), utenti, carrello.calcolaCosto()));
        for (VoceCarrello v : carrello.getVociCarrello()) {
            LineaOrdine linea= new LineaOrdine(v.getQuantita(), ordine, v.getProdotto());
            lineeOrdineDao.save(linea);
        }
    }

    @Override
    public Collection<Ordine> listaOrdini(String userName) {
        Utenti utente = utentiDao.findOne(userName);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -3);
        Date dataDiConfronto = c.getTime();
        return ordineDao.findByUtenteAndDataOrdineAfterAndAttivoIs(utente, dataDiConfronto,1);
    }

    @Override
    public void eliminaOrdine(int idOrdine) {
        Ordine ordineDaAnnullare = ordineDao.findOne(idOrdine);
        ordineDaAnnullare.setAttivo(0);
        ordineDao.save(ordineDaAnnullare);
    }

    @Override
    public float valoreOrdini(Date data) {
        List<Ordine> ordini = ordineDao.findByDataOrdineAfterAndAttivoIs(data,1);
        float parziale = 0; 
        for(Ordine o : ordini){
            parziale +=o.getPrezzoTot();
        }
        return parziale;
    }

    @Override
    public Ordine cercaOrdine(int idOrdine) {
        return ordineDao.findOne(idOrdine);
    }

//    @Override
//    public Utenti listaUtenti(Utenti utente) {
//        Utenti utenteInDb= utentiDao.findOne(utente.getUserName());
//        if (utenteInDb == null) {
//            throw new UtenteInesistenteException();
//       }
//          if (!utenteInDb.getPassword().equals(utente.getPassword())) {
//                throw new PasswordSbagliataException();
//            }
//            return utente;
//    }

    @Override
    public List<Prodotto> cercaProdotti(String nome) {
        return prodottoDao.findByNomeStartingWith(nome);
    }




}
