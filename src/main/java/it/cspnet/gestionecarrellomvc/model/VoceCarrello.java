package it.cspnet.gestionecarrellomvc.model;

import java.util.Objects;

public class VoceCarrello {

    private Prodotto prodotto;
    private int quantita;

    public VoceCarrello() {
    }

    public VoceCarrello(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public VoceCarrello(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.prodotto);
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
        final VoceCarrello other = (VoceCarrello) obj;
        if (!Objects.equals(this.prodotto, other.prodotto)) {
            return false;
        }
        return true;
    }

    public void aggiornaVoce(int i) {
        this.quantita += i;
    }

    public float calcolaCosto() {
        return this.prodotto.getPrezzo() * quantita;
    }
}
