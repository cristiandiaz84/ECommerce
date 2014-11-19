package it.cspnet.gestionecarrellomvc.repository;


import it.cspnet.gestionecarrellomvc.model.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("utentiDao")
public interface UtentiDao extends JpaRepository<Utenti, String>{

}
