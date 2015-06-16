/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Boutiques;
import com.model.Restaurants;
import com.model.Spectacles;
import com.sun.org.apache.xml.internal.resolver.helpers.Debug;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
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
 * Le Service (cuilà) appelle les EJB qui gèrent la communication avec glass/persistance et renvoient les 
 * objets/confirmlation d'action qui sont traduits en XML par le service
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
    ///////////////////////////////////////////////////////////////////////////
    ///                          SPECTACLES                                 ///
    ///////////////////////////////////////////////////////////////////////////
    @WebMethod(operationName = "getSpectacle")
    public List<Spectacles> getSpectacle(@WebParam(name = "name") String txt) {
        List<Spectacles> spectacles = spectaclesManager.getSpectacle(txt);
        
        return spectacles;
    }
    
    @WebMethod(operationName = "getSpectacleById")
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
    
    
    ///////////////////////////////////////////////////////////////////////////
    ///                          BOUTIQUES                                  ///
    ///////////////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "getBoutiqueByID")
    public List<Boutiques> getBoutiqueByID(@WebParam(name = "id") int id) {
        List<Boutiques> boutiques = boutiquesManager.getById(id);
        
        return boutiques;
    }
    
    @WebMethod(operationName = "getAllBoutiques")
    public List<Boutiques> getAllBoutiques() {
        List<Boutiques> boutiques = boutiquesManager.getAll();
        
        return boutiques;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    ///                          RESTAURANTS                                ///
    ///////////////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "getRestaurantByID")
    public List<Restaurants> getRestaurantByID(@WebParam(name = "id") int id) {
        List<Restaurants> restau = restauManager.getById(id);
        
        return restau;
    }
    
    @WebMethod(operationName = "getAllRestaurant")
    public List<Restaurants> getAllRestaurant() {
        List<Restaurants> restau = restauManager.getAll();
        
        return restau;
    }
}
