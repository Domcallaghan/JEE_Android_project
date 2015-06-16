/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.MenuRestaurant;
import com.model.Restaurants;
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
@Stateless(name="restausManager")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DAL_Restaurants {
    public List<Restaurants> getById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Restaurants.findByIdRestaurant")
                          .setParameter("idRestaurant", id);
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public List<Restaurants> getAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("Restaurants.findAll");
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
    
    public List<MenuRestaurant> getMenu(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebServiceFou-ejbPU");
        List results = null;

        EntityManager em = emf.createEntityManager();
        try {
                  Query query = em.createNamedQuery("MenuRestaurant.findByRefIdRestaurant")
                          .setParameter("RefIdRestaurant", id);
                  results = query.getResultList();
        }
        catch(Exception ex){ System.out.println( "ERROR :  " + ex.getMessage() + " AT " + ex.toString() );}
        finally {em.close();}
        return results;
    }
}
