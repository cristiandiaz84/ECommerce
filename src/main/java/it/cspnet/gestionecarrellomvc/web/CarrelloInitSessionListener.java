package it.cspnet.gestionecarrellomvc.web;


import it.cspnet.gestionecarrellomvc.model.CarrelloSpesa;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CarrelloInitSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       se.getSession().setAttribute("carrello", new CarrelloSpesa());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }
}
