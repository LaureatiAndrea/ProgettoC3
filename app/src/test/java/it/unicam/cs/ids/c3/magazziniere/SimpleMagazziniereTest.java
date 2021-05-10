package it.unicam.cs.ids.c3.magazziniere;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Classe dei test per SimpleMagazziniere.
 */
class SimpleMagazziniereTest {

    @Test
    void testGetNome() {
        SimpleMagazziniere testNomeMagazziniere =
                new SimpleMagazziniere("Andrea","Laureati");

        assertEquals(testNomeMagazziniere.getNome(),"Andrea");
        assertNotEquals(testNomeMagazziniere.getNome(),"Marco");
    }

    @Test
    void testSetNome() {
        SimpleMagazziniere testNomeMagazziniere =
                new SimpleMagazziniere("Marco","Gaetani");

        testNomeMagazziniere.setNome("Pippo");
        assertEquals("Pippo",testNomeMagazziniere.getNome());
    }

    @Test
    void testGetCognome(){
        SimpleMagazziniere testCognomeMagazziniere =
                new SimpleMagazziniere("Andrea","Laureati");

        assertEquals(testCognomeMagazziniere.getCognome(),"Laureati");
        assertNotEquals(testCognomeMagazziniere.getCognome(),"Gaetani");
    }

    @Test
    void testSetCognome() {
        SimpleMagazziniere testCognomeMagazziniere =
                new SimpleMagazziniere("Marco","Gaetani");

        testCognomeMagazziniere.setCognome("Superpippo");
        assertEquals("Superpippo",testCognomeMagazziniere.getCognome());
    }
}