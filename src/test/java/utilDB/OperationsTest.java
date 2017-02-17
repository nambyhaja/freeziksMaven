/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilDB;

import mapping.CategorieMusique;
import mapping.Musique;
import mapping.Utilisateur;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ITU
 */
public class OperationsTest {
    
    public OperationsTest() {
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
     * Test of findUtilisateur method, of class Operations.
     */
    @org.junit.Test
    public void testFindUtilisateur_String_String() throws Exception {
        System.out.println("findUtilisateur");
        String email = "michael.ratefinjanahary@gmail.com";
        String motdepasse = "prodigy";
        Utilisateur expResult = new Utilisateur(1, "Ratefinjanahary", "Michael", java.sql.Date.valueOf("1997-07-05"), 
                "michael.ratefinjanahary@gmail.com", "prodigy", "J'aime la musique");
        Utilisateur result = Operations.findUtilisateur(email, motdepasse);
        assertEquals(expResult.getIdUtilisateur(), result.getIdUtilisateur());
        System.out.println("TestFindUtilisateur passed");
    }

    /**
     * Test of findAllMusique method, of class Operations.
     */
    @org.junit.Test
    public void testFindAllMusique() throws Exception {
        System.out.println("findAllMusique");
        Musique[] expResult = new Musique[15];
        Musique[] result = Operations.findAllMusique();
        assertEquals(expResult.length, result.length);
        System.out.println("TestFindAllMusique passed");
    }

    /**
     * Test of findMusique method, of class Operations.
     */
    @org.junit.Test
    public void testFindMusique() throws Exception {
        System.out.println("findMusique");
        int idUtilisateur = 1;
        Musique[] expResult = new Musique[5];
        Musique[] result = Operations.findMusique(idUtilisateur);
        assertEquals(expResult.length, result.length);
        System.out.println("TestFindMusique passed");
    }

    /**
     * Test of findMusiquesRecents method, of class Operations.
     */
    @org.junit.Test
    public void testFindMusiquesRecents() throws Exception {
        System.out.println("findMusiquesRecents");
        Musique[] expResult = new Musique[7];
        Musique[] result = Operations.findMusiquesRecents();
        assertEquals(expResult.length, result.length);
        System.out.println("TestMusiqueRecents passed");
    }

    /**
     * Test of findMusiquesTopSemaine method, of class Operations.
     */
    @org.junit.Test
    public void testFindMusiquesTopSemaine() throws Exception {
        System.out.println("findMusiquesTopSemaine");
        Musique[] expResult = new Musique[3];
        Musique[] result = Operations.findMusiquesTopSemaine();
        assertEquals(expResult.length, result.length);
        System.out.println("TestFindMusiquesTopSemaine passed");
    }
}
