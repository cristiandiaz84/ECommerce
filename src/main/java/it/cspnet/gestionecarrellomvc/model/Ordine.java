package it.cspnet.gestionecarrellomvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Ordine.ListaOrdini", query = "SELECT o FROM Ordine o "
            + " WHERE o.utente.userName = :utente "
            + " AND o.dataOrdine > :data "
            + " AND o.attivo = 1"),
    @NamedQuery(name = "Ordine.ListaOrdiniTotale", query = "SELECT o FROM Ordine o"
            + " WHERE o.dataOrdine > :data"
            + " and o.attivo = 1 ")
})

@Table(name = "ORDINI")
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ORDINE")
    private int idOrdine;
    @Column(name = "DATA_ORDINE")
    private Date dataOrdine;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE")
    private Utenti utente;

    @OneToMany(mappedBy = "ordine")
    private Set<LineaOrdine> linea = new HashSet<>();

    @Column(name = "ATTIVO")
    private int attivo = 1;

    @Column(name = "PREZZO_TOT")
    private float prezzoTot;

    public Ordine() {
    }

    public Ordine(Date dataOrdine, Utenti utente) {
        this.dataOrdine = dataOrdine;
        this.utente = utente;
    }

    public Ordine(int idOrdine, Date dataOrdine, Utenti utente) {
        this.idOrdine = idOrdine;
        this.dataOrdine = dataOrdine;
        this.utente = utente;
    }
    
    public Ordine(Date dataOrdine,Utenti utente,float totale){
       this.dataOrdine = dataOrdine;
       this.utente=utente;
       prezzoTot=totale;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idOrdine;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordine other = (Ordine) obj;
        if (this.idOrdine != other.idOrdine) {
            return false;
        }
        return true;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public int getAttivo() {
        return attivo;
    }

    public void setAttivo(int attivo) {
        this.attivo = attivo;
    }

    public float getPrezzoTot() {
        return prezzoTot;
    }

    public void setPrezzoTot(float prezzoTot) {
        this.prezzoTot = prezzoTot;
    }
}
