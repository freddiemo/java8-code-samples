/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.sms.domain;
import java.io.Serializable;

/**
 *
 * @author Freddie Molina
 */
public class Person implements Serializable {
        
    private static final long serialVersionUID = 1L;
    private int id_person;
    private String name;
    private String last_name;
    private String email;
    private String phone;
    
    public Person() {}
    
    public Person(int id_person, String name, String last_name, String email, String phone) {
        super();
        this.id_person = id_person;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
    }
    
    public int getIdPerson() {
        return id_person;
    }
    public void setIdPerson(int id_person) {
        this.id_person = id_person;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setMail(String mail) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "Person [idPerson=" + id_person + ", name=" + name
                + ", lastNamePerson=" + last_name + ", email=" + email
                + ", phone=" + phone + "]";
    }
    
}
