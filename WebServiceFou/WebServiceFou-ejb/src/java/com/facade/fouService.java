/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Spectacles;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.Query;
import sun.util.logging.resources.logging;

/**
 *
 * @author Ugo
 */
@WebService(serviceName = "fouService")
@Stateless()
public class fouService {

    
    

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "getSpectacle")
    public List<Spectacles> getSpectacle(@WebParam(name = "name") String txt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Spectacles.findByNomSpectacle")
                          .setParameter("nomSpectacle", txt);
                  List results = query.getResultList();
                  return results;
        }
        finally {
            em.close();
        }
    }
    
    @WebMethod(operationName = "addSpectacle")
    public String addSpectacle(@WebParam(name = "id") int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");

        EntityManager em = emf.createEntityManager();
        try {
                  Spectacles s = new Spectacles(33, "test", 45, 3, "lol", 5, "la bas", "lolant");

                  em.getTransaction().begin();
                  em.persist(s);
                  em.getTransaction().commit();
                  

                  return "true";
        }
        catch(Exception ex){return "fail "+ex.getMessage() ;}
        finally { em.close();}
    }
    
}
