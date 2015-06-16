/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Boutiques;
import com.model.Spectacles;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ugo
 */
@Stateless(name="boutiquesManager")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DAL_Boutiques {
    public List<Boutiques> getById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Boutiques.findByIdBoutique")
                          .setParameter("idBoutique", id);
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public List<Boutiques> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Boutiques.findAll");
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
        public String noter(int id, float note) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        String transac ="";
        EntityManager em = emf.createEntityManager();
        try {
                  Boutiques s = em.find(Boutiques.class, id);//new Spectacles("test", 45, 3, "lol", 5, "la bas", "lolant");
                  //transac = Float.toString(s.getNoteBoutique()); //debug
                  em.getTransaction().begin();
                  s.noter(note); //em.persist(s);
                  em.getTransaction().commit();
                  

                  return "true, note:" + s.getNoteBoutique();
        }
        catch(Exception ex){ 
            
            return "ERROR :  \n" + transac + ex.getMessage() + " AT " + ex.toString() ; }
        //catch(Exception ex){ return "ERROR :  \n" + transac + ex.getMessage() + " AT " + ex.toString() ; }
        finally { em.close();}
    }
}
