/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Spectacles;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Ugo
 */
@Stateless(name="spectaclesManager")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DAL_spectacles {
    
    
    public List<Spectacles> getSpectacle(String txt) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Spectacles.findByNomSpectacle")
                          .setParameter("nomSpectacle", txt);
                  results = query.getResultList();

        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public List<Spectacles> getSpectacleById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Spectacles.findByIdSpectacle")
                          .setParameter("idSpectacle", id);
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public List<Spectacles> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Spectacles.findAll");
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public String addSpectacle(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");

        EntityManager em = emf.createEntityManager();
        try {
                  Spectacles s = new Spectacles("test", 45, 3, "lol", 5, "la bas", "lolant");

                  em.getTransaction().begin();
                  em.persist(s);
                  em.getTransaction().commit();
                  

                  return "true";
        }
        catch(Exception ex){ return "ERROR :  " + ex.getMessage() + " AT " + ex.toString() ;}
        finally { em.close();}
    }
    
    public String noterSpectacle(int id, int note) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        String transac ="";
        EntityManager em = emf.createEntityManager();
        try {
                  Spectacles s = em.find(Spectacles.class, id);//new Spectacles("test", 45, 3, "lol", 5, "la bas", "lolant");
                  transac = Integer.toString(s.getNoteSpectacle());
                  em.getTransaction().begin();
                  s.noter(note); //em.persist(s);
                  em.getTransaction().commit();
                  

                  return "true, note:" + s.getNoteSpectacle();
        }
        catch(Exception ex){ 
            
            return "ERROR :  \n" + transac + ex.getMessage() + " AT " + ex.toString() ; }
        //catch(Exception ex){ return "ERROR :  \n" + transac + ex.getMessage() + " AT " + ex.toString() ; }
        finally { em.close();}
    }
    
}