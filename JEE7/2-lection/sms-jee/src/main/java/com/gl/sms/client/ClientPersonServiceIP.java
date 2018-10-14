/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.sms.client;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.gl.sms.domain.Person;
import com.gl.sms.service.PersonServiceRemote;

/**
 *
 * @author Freddie Molina
 */
public class ClientPersonServiceIP {
    
    public static void main(String[] args) {
        System.out.println("Initiating call to the EJB from the client\n");
        try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            // optional. Default localhost. Here the IP of the server where glassfish is changed
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            // optional. Only by Default 3700. You only need to change if the the port is not 3700
            // props.setProperty("orgs.omg.CORBA.ORBInitialHost", "3700");
            Context jndi = new InitialContext(props);
            PersonServiceRemote personService = 
                (PersonServiceRemote) jndi.lookup("java:global/sms-jee/PersonServiceImpl!com.gl.sms.service.PersonServiceRemote");
            
            List<Person> persons = personService.listPersons();
            
            for (Person person : persons) {
                System.out.println(person);
            }
            System.out.println("\nEnd call to EJB from the client");
        }   
        catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
