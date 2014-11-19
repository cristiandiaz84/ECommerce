package it.cspnet.gestionecarrellomvc.web;

import it.cspnet.gestionecarrellomvc.model.Ordine;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import it.cspnet.gestionecarrellomvc.servizi.ServiziEcommerce;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrdiniController {
    
    @Autowired
    private ServiziEcommerce servizi;
    
    @RequestMapping(value="/riepilogomese",method = RequestMethod.GET)
    public String riepilogomese(@ModelAttribute("utile") Utenti utente, HttpServletRequest req){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -30);
        Date data = c.getTime();
        req.setAttribute("guadagno", servizi.valoreOrdini(data));
        return "riepilogomese";
    }
    
    @RequestMapping(value="/listaordini",method = RequestMethod.GET)
    public String listaOrdini(@ModelAttribute("utente") Utenti utente,HttpServletRequest req){
        Utenti utenti = (Utenti) req.getSession().getAttribute("utenteInDB");
        req.setAttribute("ordini", servizi.listaOrdini(utenti.getUserName()));
        return "listaordini";
    }
    
    @RequestMapping(value="eliminaOrdine",method = RequestMethod.GET)
    public String eliminaOrdine(@ModelAttribute("ordine")Ordine ordine,HttpServletRequest req){
        int idOrdine = Integer.parseInt(req.getParameter("idOrdine"));
        Utenti utenti = (Utenti) req.getSession().getAttribute("utenteInDB");
        servizi.eliminaOrdine(idOrdine);
        req.setAttribute("ordini", servizi.listaOrdini(utenti.getUserName()));
        return "listaordini";
    }
}
