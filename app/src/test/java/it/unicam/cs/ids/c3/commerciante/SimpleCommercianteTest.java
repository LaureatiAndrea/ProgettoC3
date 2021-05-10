package it.unicam.cs.ids.c3.commerciante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe dei test per SimpleCommerciante.
 */
class SimpleCommercianteTest {

    @Test
    void testGetId() {
        SimpleCommerciante testIdCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        assertEquals(testIdCommerciante.getId(),2);
    }

    @Test
    void testSetId() {
        SimpleCommerciante testIdCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        testIdCommerciante.setId(5);
        assertEquals(testIdCommerciante.getId(),5);
        assertNotEquals(testIdCommerciante.getId(),2);
    }

    @Test
    void testGetNome() {
        SimpleCommerciante testNomeCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        assertEquals(testNomeCommerciante.getNome(),"Angelo");
    }

    @Test
    void testSetNome() {
        SimpleCommerciante testNomeCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        testNomeCommerciante.setNome("Elia");
        assertEquals(testNomeCommerciante.getNome(),"Elia");
        assertNotEquals(testNomeCommerciante.getNome(),"Angelo");
    }

    @Test
    void testGetCognome() {
        SimpleCommerciante testCognomeCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        assertEquals(testCognomeCommerciante.getCognome(),"Paradiso");
    }

    @Test
    void testSetCognome() {
        SimpleCommerciante testCognomeCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        testCognomeCommerciante.setCognome("Purgatorio");
        assertEquals(testCognomeCommerciante.getCognome(),"Purgatorio");
        assertNotEquals(testCognomeCommerciante.getCognome(),"Paradiso");
    }

    @Test
    void testGetPartitaIva() {
        SimpleCommerciante testPartitaIvaCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        assertEquals(testPartitaIvaCommerciante.getPartitaIva(),"12345687911");
    }

    @Test
    void testSetPartitaIva() {
        SimpleCommerciante testPartitaIvaCommerciante =
                new SimpleCommerciante(2,"Angelo", "Paradiso","12345687911");
        testPartitaIvaCommerciante.setPartitaIva("10101010101");
        assertEquals(testPartitaIvaCommerciante.getPartitaIva(),"10101010101");
        assertNotEquals(testPartitaIvaCommerciante.getPartitaIva(),"12345687911");
    }

}