/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.junit.Assert.*;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import com.gl.sms.domain.Person;
import com.gl.sms.service.PersonService;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Freddie Molina
 */
public class PersonServiceTest {
    
    private PersonService personService;
    
    @Before
    public void setUp() throws Exception {
        EJBContainer container = EJBContainer.createEJBContainer();
        personService = (PersonService)
                container.getContext().lookup("java:global/classes/PersonServiceImpl!com.gl.sms.service.PersonService");
    }
    
    @Test
    public void testEJBPersonService() {
        System.out.println("Initiating test EJB PersonService");
        assertTrue(personService != null);
        
        assertEquals(2, personService.listPersons().size());
        
        System.out.println("The number of people is equal to: " + personService.listPersons().size());
        
        this.deployPersons(personService.listPersons());
        System.out.println("End test EJB PersonService");
    }
    
    private void deployPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
