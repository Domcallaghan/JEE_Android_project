/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Boutiques;
import com.model.Spectacles;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import javax.persistence.Query;
import sun.util.logging.resources.logging;

/**
 *
 * @author Ugo
 * Le Servcice (cuilà) appelle les EJB qui gèrent la communication avec glass/persistance et renvoient les 
 * objets/confirmlation d'action qui sont traduits en XML par le service
 * un EJB par table
 */
@WebService(serviceName = "fouService")
@Stateless(name="fouService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class fouService {

    @EJB
    private DAL_spectacles spectaclesManager;
    
    @EJB
    private DAL_Boutiques boutiquesManager;
    
    @EJB
    private DAL_Restaurants restauManager;
    

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getSpectacle")
    public List<Spectacles> getSpectacle(@WebParam(name = "name") String txt) {
        List<Spectacles> spectacles = spectaclesManager.getSpectacle(txt);
        
        return spectacles;
    }
    
    @WebMethod(operationName = "getSpectacleByID")
    public List<Spectacles> getSpectaclebyId(@WebParam(name = "id") int id) {
        List<Spectacles> spectacles = spectaclesManager.getSpectacleById(id);
        
        return spectacles;
    }
    
    @WebMethod(operationName = "getAllSpectacles")
    public List<Spectacles> getAllSpectacles() {
        List<Spectacles> spectacles = spectaclesManager.getAll();
        
        return spectacles;
    }
    
    @WebMethod(operationName = "addSpectacle")
    public String addSpectacle(@WebParam(name = "id") int id) {
        return spectaclesManager.addSpectacle(id);
    }
    
    @WebMethod(operationName = "noterSpectacle")
    public String noterSpectacle(@WebParam(name = "id") int id, @WebParam(name = "note") int note) {
        return spectaclesManager.noterSpectacle(id, note);
    }
    
    @WebMethod(operationName = "getBoutiqueByID")
    public List<Boutiques> getBoutiqueByID(@WebParam(name = "id") int id) {
        List<Boutiques> boutiques = boutiquesManager.getById(id);
        
        return boutiques;
    }
}
