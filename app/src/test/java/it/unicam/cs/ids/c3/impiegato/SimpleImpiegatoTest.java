package it.unicam.cs.ids.c3.impiegato;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe dei test per SimpleImpiegato.
 */
class SimpleImpiegatoTest {

    @Test
    void testGetId() {
        SimpleImpiegato testIdImpiegato =
                new SimpleImpiegato(1,"Andrea","Laureati",6);

        assertEquals(testIdImpiegato.getId(),1);
        assertNotEquals(testIdImpiegato.getId(),34);
    }

    @Test
    void testSetId() {
        SimpleImpiegato testNomeImpiegato =
                new SimpleImpiegato(1,"Marco","Gaetani",17);

        testNomeImpiegato.setId(2);
        assertEquals(2,testNomeImpiegato.getId());
    }

    @Test
    void testGetNome() {
        SimpleImpiegato testNomeImpiegato =
                new SimpleImpiegato(1,"Andrea","Laureati",6);

        assertEquals(testNomeImpiegato.getNome(),"Andrea");
        assertNotEquals(testNomeImpiegato.getNome(),"Marco");
    }

    @Test
    void testSetNome() {
        SimpleImpiegato testNomeImpiegato =
                new SimpleImpiegato(1,"Marco","Gaetani",17);

        testNomeImpiegato.setNome("Pippo");
        assertEquals("Pippo",testNomeImpiegato.getNome());
    }

    @Test
    void testGetCognome(){
        SimpleImpiegato testCognomeImpiegato =
                new SimpleImpiegato(1,"Andrea","Laureati",6);

        assertEquals(testCognomeImpiegato.getCognome(),"Laureati");
        assertNotEquals(testCognomeImpiegato.getCognome(),"Gaetani");
    }

    @Test
    void testSetCognome() {
        SimpleImpiegato testCognomeImpiegato =
                new SimpleImpiegato(1,"Marco","Gaetani",17);

        testCognomeImpiegato.setCognome("Superpippo");
        assertEquals("Superpippo",testCognomeImpiegato.getCognome());
    }

    @Test
    void testEquals() {
        SimpleImpiegato impiegato =
                new SimpleImpiegato(1, "impiegato", "bottega", 8);
        SimpleImpiegato stessoImpiegato =
                new SimpleImpiegato(1, "impiegato", "bottega", 8);
        SimpleImpiegato impiegato2 =
                new SimpleImpiegato(2, "commesso", "globo", 11);
        SimpleImpiegato diversoNome =
                new SimpleImpiegato(2, "diversoNome", "globo",11);
        SimpleImpiegato diversoCognome =
                new SimpleImpiegato(2, "commesso", "diversoCognome", 11);

        assertEquals(impiegato, stessoImpiegato);
        assertNotEquals(impiegato, impiegato2);
        assertNotEquals(impiegato2, diversoNome);
        assertNotEquals(impiegato2, diversoCognome);
    }

    @Test
    void testHashCode() {
        SimpleImpiegato impiegato =
                new SimpleImpiegato(1, "impiegato", "bottega", 8);
        SimpleImpiegato stessoImpiegato =
                new SimpleImpiegato(1, "impiegato", "bottega", 8);
        SimpleImpiegato impiegato2 =
                new SimpleImpiegato(2, "commesso", "globo", 11);
        SimpleImpiegato diversoNome =
                new SimpleImpiegato(2, "diversoNome", "globo",11);
        SimpleImpiegato diversoCognome =
                new SimpleImpiegato(2, "commesso", "diversoCognome", 11);

        assertEquals(impiegato.hashCode(), stessoImpiegato.hashCode());
        assertNotEquals(impiegato.hashCode(), impiegato2.hashCode());
        assertNotEquals(impiegato2.hashCode(), diversoNome.hashCode());
        assertNotEquals(impiegato2.hashCode(), diversoCognome.hashCode());
    }

}