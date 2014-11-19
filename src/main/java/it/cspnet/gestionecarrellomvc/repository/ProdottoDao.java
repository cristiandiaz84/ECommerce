package it.cspnet.gestionecarrellomvc.repository;


import it.cspnet.gestionecarrellomvc.model.Prodotto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("prodottoDao")
public interface ProdottoDao extends JpaRepository<Prodotto, Integer>{

    public List<Prodotto> findByNomeStartingWith(String nome);

    
   
}
