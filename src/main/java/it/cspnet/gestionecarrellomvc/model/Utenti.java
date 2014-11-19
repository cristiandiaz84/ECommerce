package it.cspnet.gestionecarrellomvc.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "UTENTI")
public class Utenti implements Serializable {

    @Id
    @Column(name = "USERNAME")
    @NotEmpty
    private String userName;
    @Column(name = "NOMECOGNOME", nullable = false, length = 50)
    private String nomeCognome;
    @Column(name = "PASSWORD", nullable = false, length = 20)
    @NotEmpty
    private String password;
    @Column(name = "PROFILO", nullable = false, length = 20)
    private String profilo="normale";

    @OneToMany(mappedBy = "utente")
    private Set<Ordine> ordine;

    public Utenti(String userName, String nomeCognome, String password, String profilo) {
        this.userName = userName;
        this.nomeCognome = nomeCognome;
        this.password = password;
        this.profilo = profilo;
    }

    public Utenti() {
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilo() {
        return profilo;
    }

    public void setProfilo(String profilo) {
        this.profilo = profilo;
    }

    public Set<Ordine> getOrdine() {
        return ordine;
    }

    public void setOrdine(Set<Ordine> ordine) {
        this.ordine = ordine;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.userName);
        hash = 29 * hash + Objects.hashCode(this.password);
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
        final Utenti other = (Utenti) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
}
