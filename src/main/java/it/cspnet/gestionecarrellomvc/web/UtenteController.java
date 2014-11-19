package it.cspnet.gestionecarrellomvc.web;

import it.cspnet.gestionecarrellomvc.model.Prodotto;
import it.cspnet.gestionecarrellomvc.model.Utenti;
import it.cspnet.gestionecarrellomvc.servizi.PasswordSbagliataException;
import it.cspnet.gestionecarrellomvc.servizi.ServiziEcommerce;
import it.cspnet.gestionecarrellomvc.servizi.UtenteEsistenteException;
import it.cspnet.gestionecarrellomvc.servizi.UtenteInesistenteException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class UtenteController {
    @Autowired
    private ServiziEcommerce servizi;

    public void setServizi(ServiziEcommerce servizi) {
        this.servizi = servizi;
    }
     
    
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String index(@ModelAttribute("utente") Utenti utente) {
        return "login";
    }
    
    @RequestMapping(value="home")
    public String home(@ModelAttribute("utente") Utenti utente){
        return "home";
    }
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(HttpServletRequest req,@Valid @ModelAttribute("utente") Utenti utente, BindingResult result) {
        RequestContext ctx = new RequestContext(req);
        
        if(result.hasErrors()){
            return "login";
        }
        Utenti utenteInDb = null;
        try {
           utenteInDb = servizi.listaUtenti(utente.getUserName(), utente.getPassword()); 
           req.getSession().setAttribute("utenteInDB", utenteInDb);
           return "home";
        } catch (UtenteInesistenteException ex) {
            String messagefromBundle = ctx.getMessage("username.error");
            req.setAttribute("messaggio", messagefromBundle);
            return "login";
        } catch (PasswordSbagliataException ex) {
            String messagefromBundle = ctx.getMessage("password.error");
            req.setAttribute("messaggio", messagefromBundle);
            return "login";
        } catch (Exception ex) {
            String messagefromBundle = ctx.getMessage("general.error");
            req.setAttribute("messaggio", messagefromBundle);
            System.out.println(ex);
            return "login";
        }
    }
    
    @RequestMapping(value="/registrati",method = RequestMethod.GET)
    public String moduloRegistrazione(@ModelAttribute("utente") Utenti utente,HttpServletRequest req){
        return "registrati";
    }
    
    @RequestMapping(value="/registrati",method = RequestMethod.POST)
    public String registrati(HttpServletRequest req,@Valid @ModelAttribute("utente") Utenti utente,BindingResult result){
        RequestContext ctx = new RequestContext(req);
        if(result.hasErrors()){
            return "registrati";
        }
         try{
           Utenti utenteRegistrato = servizi.creaUtente(utente);
           return "login";
        } catch (UtenteEsistenteException ex) {
            String messagefromBundle = ctx.getMessage("username_2.error");
            req.setAttribute("messaggio", messagefromBundle);
            return "registrati";
        } 
    }
    
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest req){
        req.getSession().invalidate();
        return "forward:login.do";
    }
}
