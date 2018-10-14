/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.sms.service;

import java.util.List;
import javax.ejb.Local;
import com.gl.sms.domain.Person;

/**
 *
 * @author Freddie Molina
 */
@Local
public interface PersonService {
    
    public List<Person> listPersons();
    
    public Person findPersonById(Person person);
    
    public Person findPersonByEmail(Person person);
    
    public void registerPerson(Person person);
    
    public void modifyPerson(Person person);
    
    public void deletePerson(Person person);
    
}
