/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import beans.domain.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Freddie Molina
 */
public class ClientEntityPerson {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        // Start the transaction
        tx.begin();
        // The ID must not be specificate, it's generated automatically
        Person person1 = new Person("Maria", "Gutierrez", "maria@gmail.com", "11113333");
        log.debug("Object to persist" + person1);
        // Persist the object
        em.persist(person1);
        // Finished the transaction
        tx.commit();
        log.debug("Persisted object:" + person1);
        em.close();
    }
    
}
