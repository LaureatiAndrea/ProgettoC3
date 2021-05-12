package it.unicam.cs.ids.c3.corriere;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe dei test per SimpleCorriere.
 */
class SimpleCorriereTest {

    @Test
    void testGetId() {
        SimpleCorriere testIdCorriere =
                new SimpleCorriere(1,"Andrea","Laureati");

        assertEquals(testIdCorriere.getId(),1);
        assertNotEquals(testIdCorriere.getId(),34);
    }

    @Test
    void testSetId() {
        SimpleCorriere testIdCorriere =
                new SimpleCorriere(1,"Marco","Gaetani");

        testIdCorriere.setId(2);
        assertEquals(2,testIdCorriere.getId());
    }

    @Test
    void testGetNome() {
        SimpleCorriere testNomeCorriere =
                new SimpleCorriere(1,"Andrea","Laureati");

        assertEquals(testNomeCorriere.getNome(),"Andrea");
        assertNotEquals(testNomeCorriere.getNome(),"Marco");
    }

    @Test
    void testSetNome() {
        SimpleCorriere testNomeCorriere =
                new SimpleCorriere(1,"Marco","Gaetani");

        testNomeCorriere.setNome("Pippo");
        assertEquals("Pippo",testNomeCorriere.getNome());
    }

    @Test
    void testGetCognome(){
        SimpleCorriere testCognomeCorriere =
                new SimpleCorriere(1,"Andrea","Laureati");

        assertEquals(testCognomeCorriere.getCognome(),"Laureati");
        assertNotEquals(testCognomeCorriere.getCognome(),"Gaetani");
    }

    @Test
    void testSetCognome() {
        SimpleCorriere testCognomeCorriere =
                new SimpleCorriere(1,"Marco","Gaetani");

        testCognomeCorriere.setCognome("Superpippo");
        assertEquals("Superpippo",testCognomeCorriere.getCognome());
    }

    @Test
    void testGetStato() {
        SimpleCorriere testStatoCorriere =
                new SimpleCorriere(1,"corriere", "bartolini");
        testStatoCorriere.setStato(Stato_Corriere.DISPONIBILE);

     assertEquals(testStatoCorriere.getStato(), Stato_Corriere.DISPONIBILE);
    }

    @Test
    void testSetStato() {
        SimpleCorriere testStatoCorriere =
                new SimpleCorriere(1,"corriere", "bartolini");
        testStatoCorriere.setStato(Stato_Corriere.DISPONIBILE);

        testStatoCorriere.setStato(Stato_Corriere.NON_DISPONIBILE);
        assertEquals(testStatoCorriere.getStato(), Stato_Corriere.NON_DISPONIBILE);
        assertNotEquals(testStatoCorriere.getStato(), Stato_Corriere.DISPONIBILE);
    }

    @Test
    void testEquals() {
        SimpleCorriere corriere =
                new SimpleCorriere(1, "corriere", "bartolini");
        SimpleCorriere stessoCorriere =
                new SimpleCorriere(1, "corriere", "bartolini");
        SimpleCorriere corriere2 =
                new SimpleCorriere(2, "trasporto", "poste");
        SimpleCorriere diversoNome =
                new SimpleCorriere(2, "diversoNome", "poste");
        SimpleCorriere diversoCognome =
                new SimpleCorriere(2, "trasporto", "diversoCognome");

        assertEquals(corriere, stessoCorriere);
        assertNotEquals(corriere, corriere2);
        assertNotEquals(corriere2, diversoNome);
        assertNotEquals(corriere2, diversoCognome);
    }

    @Test
    void testHashCode() {
        SimpleCorriere corriere =
                new SimpleCorriere(1, "corriere", "bartolini");
        SimpleCorriere stessoCorriere =
                new SimpleCorriere(1, "corriere", "bartolini");
        SimpleCorriere corriere2 =
                new SimpleCorriere(2, "trasporto", "poste");
        SimpleCorriere diversoNome =
                new SimpleCorriere(2, "diversoNome", "poste");
        SimpleCorriere diversoCognome =
                new SimpleCorriere(2, "trasporto", "diversoCognome");

        assertEquals(corriere.hashCode(), stessoCorriere.hashCode());
        assertNotEquals(corriere.hashCode(), corriere2.hashCode());
        assertNotEquals(corriere2.hashCode(), diversoNome.hashCode());
        assertNotEquals(corriere2.hashCode(), diversoCognome.hashCode());
    }

}