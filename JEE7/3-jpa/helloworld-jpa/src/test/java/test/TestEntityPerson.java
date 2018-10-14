/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.domain.Person;

/**
 *
 * @author Freddie Molina
 */
public class TestEntityPerson {
    
    static EntityManager em = null;
    static EntityTransaction tx = null;
    static EntityManagerFactory emf = null;
    Logger log = LogManager.getRootLogger();
    
    @BeforeClass
    public static void init() throws Exception {
        emf = Persistence.createEntityManagerFactory("PersonPU");
    }
    
    @Before
    public void setup() {
        try {
            em = emf.createEntityManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testPersonEntity() {
        log.debug("Initiating test Person Entity with JPA");
        
        assertTrue(em != null);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        // The ID must not be specificate, it's generated automatically
        Person person1 = new Person("Oscar", "Gomez", "ogomez@gmail.com", "55780109");
        
        log.debug("Object to persist:" + person1);
        
        em.persist(person1);
        tx.commit();
        
        assertTrue(person1.getIdPerson() != null);
        
        log.debug("Persisted object:" + person1);
        log.debug("End test Person Entity with JPA");
    }
    
    @After
    public void tearDown() throws Exception {
        if (em != null) {
            em.close();
        }
    }
 
}
