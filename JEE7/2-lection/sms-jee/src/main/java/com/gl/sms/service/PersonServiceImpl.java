/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.sms.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import com.gl.sms.domain.Person;

/**
 *
 * @author Freddie Molina
 */
@Stateless
public class PersonServiceImpl implements PersonServiceRemote {
    
    @Override
    public List<Person> listPersons() {
        List<Person> persons = new ArrayList<> ();
        persons.add(new Person(1, "Juan", "Perez", "jperez@gmail.com", "55668798"));
        persons.add(new Person(2, "Martha", "Suarez", "msuarez@gmail.com", "566998811"));
        return persons;
    }
    
    @Override
    public Person findPersonById(Person person) {
        return null;
    }
    
    @Override
    public Person findPersonByEmail(Person person) {
        return null;
    }
    
    @Override
    public void registerPerson(Person person) {};
    
    @Override
    public void modifyPerson(Person person) {};
    
    @Override
    public void deletePerson(Person person) {};
    
}
