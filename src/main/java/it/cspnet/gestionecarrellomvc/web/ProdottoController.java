package it.cspnet.gestionecarrellomvc.web;

import it.cspnet.gestionecarrellomvc.model.CarrelloSpesa;
import it.cspnet.gestionecarrellomvc.model.Prodotto;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import it.cspnet.gestionecarrellomvc.servizi.ServiziEcommerce;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class ProdottoController {
    @Autowired
    private ServiziEcommerce servizi;

    public void setServizi(ServiziEcommerce servizi) {
        this.servizi = servizi;
    }
    
    @RequestMapping(value="listaprodotti",method = RequestMethod.GET)
    public String vissualizzaProdotti(@ModelAttribute("prodotto") Prodotto prodotto, HttpServletRequest req){
        Collection<Prodotto> prodotti = servizi.listaProdotti();
        req.setAttribute("prodotti", prodotti);
        return "listaprodotti";
    }
    
    @RequestMapping(value="aggiungiacarrello",method = RequestMethod.GET)
    public String aggiungiACarrello(@ModelAttribute("prodotto") Prodotto prodotto, HttpServletRequest req){
        int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
        Prodotto p = servizi.cercaProdotto(idProdotto);
        CarrelloSpesa carrello = (CarrelloSpesa) req.getSession().getAttribute("carrello");
        carrello.aggiornaVoce(p, 1);
        return "forward:listaprodotti.do";
    }
    
    @RequestMapping(value="acquista",method = RequestMethod.GET)
    public String acquista(@ModelAttribute("prodotto")Prodotto prodotto,HttpServletRequest req){
        CarrelloSpesa carrello = (CarrelloSpesa) req.getSession().getAttribute("carrello");
        Utenti utenti = (Utenti) req.getSession().getAttribute("utenteInDB");
        servizi.acquista(carrello,utenti);
        carrello.svuota();
        RequestContext ctx = new RequestContext(req);
        String messagefromBundle = ctx.getMessage("acquisto");
        req.setAttribute("messaggio", messagefromBundle);
        return "forward:listaprodotti.do";
    }
    
    @RequestMapping(value="eliminaVoce",method = RequestMethod.GET)
    public String eliminaVoce(@ModelAttribute("prodotto") Prodotto prodotto,HttpServletRequest req){
       int idProdotto = Integer.parseInt(req.getParameter("idProdotto"));
       CarrelloSpesa carrello = (CarrelloSpesa)req.getSession().getAttribute("carrello");
       carrello.aggiornaVoce(servizi.cercaProdotto(idProdotto), -1);
       return "forward:listaprodotti.do";
    }
    // viene attivata dalla richiesta ascingrona (in questo caso dal tasto premuto sulla tastiera)
    // e devofar caricare una pagina jsp che farà visualizzare il risultato
    @RequestMapping(value="/getProdotti",method = RequestMethod.GET)
    public String getProdotti(HttpServletRequest req){
        List<Prodotto> prodotti = servizi.cercaProdotti(req.getParameter("nome"));
        req.setAttribute("prodotti", prodotti);
        return "data";
    }

}
