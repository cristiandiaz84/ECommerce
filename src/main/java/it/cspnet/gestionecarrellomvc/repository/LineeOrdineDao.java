package it.cspnet.gestionecarrellomvc.repository;


import it.cspnet.gestionecarrellomvc.model.LineaOrdine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lineeOrdineDao")
public interface LineeOrdineDao extends JpaRepository<LineaOrdine, Integer>{
  
}
