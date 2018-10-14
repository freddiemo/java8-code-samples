/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.sms.client;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.gl.sms.domain.Person;
import com.gl.sms.service.PersonServiceRemote;

/**
 *
 * @author Freddie Molina
 */
public class ClientPersonService {
    
    public static void main(String[] args) {
        System.out.println("Initiating EJB call from the client\n");
        try {
            Context jndi = new InitialContext();
            PersonServiceRemote personService = 
                (PersonServiceRemote) jndi.lookup("java:global/sms-jee/PersonServiceImpl!com.gl.sms.service.PersonServiceRemote");
            
            List<Person> persons = personService.listPersons();
            
            for (Person person : persons) {
                System.out.println(person);
            }
            System.out.println("\nEnd call to EJB from the client");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
}
