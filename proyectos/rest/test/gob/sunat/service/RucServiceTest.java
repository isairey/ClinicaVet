/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.sunat.service;

import gob.sunat.pojo.Ruc;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cesar
 */
public class RucServiceTest {
    
    public RucServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of getRucByRuc method, of class RucService.
     */
    @Test
    public void testGetRucByRuc() {
        System.out.println("getRucByRuc");
        String ruc = "aaaaaaa";
        RucService instance = new RucService();

        Ruc result = instance.getRucByRuc(ruc);
        assertTrue(1 == result.getIdRuc());

    }
    
    
    

    /**
     * Test of addRuc method, of class RucService.
     */
    @Test
    public void testAddRuc() {
        
        String ramdom = Math.round( Math.random() * 1000 ) + "";                
        String ruc = "ruc" + ramdom;
        
        System.out.println("addRuc con ruc => " + ruc);
        String nombre = "nombre" + ramdom;
        String dni = "dni" + ramdom;
        RucService instance = new RucService();
         
        Ruc result = instance.addRuc(ruc, nombre, dni);
        assertEquals(ruc, result.getRuc());       
    }
    
       @Test
    public void testGetFirstRuc() {
       
        RucService instance = new RucService();
         
        Ruc result = instance.getRucByIdRuc(1);
        assertTrue(1 ==  result.getIdRuc());       
    }
  
    /**
     * Test of editRuc method, of class RucService.
     */
    @Test
    public void testEditRuc() {
       
        String ramdom = Math.round( Math.random() * 1000 ) + "";                
        String ruc = "ruc" + ramdom;
         System.out.println("editRuc con ruc " + ruc);
        String idRuc = "1";

        String nombre = "nombre " + ramdom;
        String dni = "dni " + ramdom;
        RucService instance = new RucService();
        
        Ruc result = instance.editRuc(idRuc, ruc, nombre, dni);
         System.out.println("editRuc => " + ruc + " di ant"+ idRuc+    " con id nueo" + result.getIdRuc() );
        assertEquals(nombre, result.getNombre());
        
    }

    /**
     * Test of deleteRuc method, of class RucService.
     */
    @Test
    public void testDeleteRuc() {
       
        String ramdom = Math.round( Math.random() * 1000 ) + "";                
        String ruc = "ruc" + ramdom;
        
        System.out.println("addRuc con ruc => " + ruc);
        String nombre = "nombre" + ramdom;
        String dni = "dni" + ramdom;
        RucService instance = new RucService();
         
        Ruc result = instance.addRuc(ruc, nombre, dni);
        
         System.out.println("deleteRuc " + ruc + " id => " +result.getIdRuc())  ;
        boolean borrado = instance.deleteRuc(result.getIdRuc() + "");
        assertTrue(borrado);
    }
}