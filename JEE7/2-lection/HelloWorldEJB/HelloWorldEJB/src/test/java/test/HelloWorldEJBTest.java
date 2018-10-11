/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Before;
import beans.HelloWorldEJB;

/**
 *
 * @author Freddie Molina
 */
public class HelloWorldEJBTest {
    
    private static EJBContainer container;
    private static Context context;
    private static HelloWorldEJB ejb;
    
    @Before
    public void startContainer() throws Exception {
        System.out.println("Starting EJB Container");
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
        ejb = (HelloWorldEJB) context.lookup("java:global/classes/HelloWorldEJB!beans.HelloWorldEJB");
    }
    
    @Test
    public void testAddNumbers() throws Exception {
        int data1 = 3;
        int data2 = 5;
        int result = ejb.sum(data1, data2);
        assertEquals((data1 + data2), result);
        System.out.println("\nFinished operation, result: " + result + "\n");
    }
    
}
