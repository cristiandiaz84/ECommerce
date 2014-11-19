package it.cspnet.gestionecarrellomvc.repository;


import it.cspnet.gestionecarrellomvc.model.Ordine;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ordineDao")
public interface OrdineDao extends JpaRepository<Ordine, Integer>{

    public Collection<Ordine> findByUtenteAndDataOrdineAfterAndAttivoIs(Utenti utente, Date dataDiConfronto,int attivo);

    public List<Ordine> findByDataOrdineAfterAndAttivoIs(Date data, int attivo);
}
