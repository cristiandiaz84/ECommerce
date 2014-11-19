package it.cspnet.gestionecarrellomvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Prodotto.ListaProdotti", query
    = "SELECT p FROM Prodotto p")
@Table(name = "PRODOTTI")
public class Prodotto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODOTTO")
    private int idProdotto;
    @Column(name = "PREZZO", nullable = false)
    private float prezzo;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @OneToMany(mappedBy = "prodotto")
    private Set<LineaOrdine> linea = new HashSet<>();

    public Prodotto() {
    }

    public Prodotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idProdotto;
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
        final Prodotto other = (Prodotto) obj;
        if (this.idProdotto != other.idProdotto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "idProdotto=" + idProdotto + ", prezzo=" + prezzo + ", nome=" + nome + ", descrizione=" + descrizione + '}';
    }
}
