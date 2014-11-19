package it.cspnet.gestionecarrellomvc.model;

import java.util.ArrayList;
import java.util.List;

public class CarrelloSpesa {

    private List<VoceCarrello> vociCarrello;

    public CarrelloSpesa() {
        vociCarrello = new ArrayList<>();
    }

    public void aggiornaVoce(Prodotto p, int i) {
        if (vociCarrello.contains(new VoceCarrello(p))) {
            int indice = vociCarrello.indexOf(new VoceCarrello(p));
            vociCarrello.get(indice).aggiornaVoce(i);
            if (vociCarrello.get(indice).getQuantita() <= 0) {
                vociCarrello.remove(new VoceCarrello(p));
            }
        } else {
            vociCarrello.add(new VoceCarrello(p, 1));
        }
    }

    public float calcolaCosto() {
        float costo = 0;
        for (VoceCarrello v : vociCarrello) {
            costo += v.calcolaCosto();
        }
        return costo;
    }

    public int size() {
        return vociCarrello.size();
    }

    public List<VoceCarrello> getVociCarrello() {
        return vociCarrello;
    }

    public void svuota() {
        vociCarrello = new ArrayList<>();
    }
}
