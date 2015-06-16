/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.model.Boutiques;
import com.model.Spectacles;
import com.sun.net.httpserver.Authenticator;
import com.facade.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ugo
 */
public class fouServiceTest {
    
    
    /*@EJB(beanName = "fouService", mappedName = "fouService")
    private fouService fs;
    
    @PersistenceContext(unitName = "WebServiceFou-ejbPU")
    protected EntityManager em;*/
    
     private Context  ctx;
     private EJBContainer ejbContainer;
    
    public fouServiceTest() {
    }
    
     /*@BeforeClass
    public  void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Opening the container" );
        ctx = ejbContainer.getContext();
    }*/

    /*@AfterClass
    public  void tearDown() {
        ejbContainer.close();
        System.out.println("Closing the container" );
    }*/
    




    /**
     * Test of getSpectaclebyId method, of class fouService.
     */
    @Test
    public void testGetSpectaclebyId() throws Exception {
        ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Opening the container" );
        ctx = ejbContainer.getContext();
        
        fouService fs = (fouService) ctx.lookup("java:global/classes/fouService");
        assertNotNull(fs);

        System.out.println("getSpectaclebyId");
        int id = 1;
        List<Spectacles> spec = fs.getSpectaclebyId(id);
        String result = spec.get(0).getNomSpectacle();
        String expResult = "Le signe du triomphe";
        assertEquals(expResult, result);   
        
        ejbContainer.close();
        System.out.println("Closing the container" );
    }
    
}
