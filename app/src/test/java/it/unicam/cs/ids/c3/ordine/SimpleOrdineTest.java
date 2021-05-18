package it.unicam.cs.ids.c3.ordine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleOrdineTest {

    @Test
    void testGetIdCliente() {
        SimpleOrdine testIdCliente =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        assertEquals(testIdCliente.getIdCliente(),1);
        assertNotEquals(testIdCliente.getIdCliente(),3);
    }

    @Test
    void testSetIdCliente() {
        SimpleOrdine testIdCliente =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        testIdCliente.setIdCliente(11);
        assertEquals(testIdCliente.getIdCliente(),11);
        assertNotEquals(testIdCliente.getIdCliente(),1);
    }

    @Test
    void testGetIdCorriere() {
        SimpleOrdine testIdCorriere =
                new SimpleOrdine(0,5,7,"casa",8,6,"postit");

        assertEquals(testIdCorriere.getIdCorriere(),7);
        assertNotEquals(testIdCorriere.getIdCorriere(),5);
    }

    @Test
    void testSetIdCorriere() {
        SimpleOrdine testIdCorriere =
                new SimpleOrdine(0,5,7,"casa",8,6,"postit");

        testIdCorriere.setIdCorriere(17);
        assertEquals(testIdCorriere.getIdCorriere(),17);
        assertNotEquals(testIdCorriere.getIdCorriere(),7);
    }

    @Test
    void testGetDestinazione() {
        SimpleOrdine testDestinazione =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        assertEquals(testDestinazione.getDestinazione(),"destinazione");
        assertNotEquals(testDestinazione.getDestinazione(),"ultima");
    }

    @Test
    void testSetDestinazione() {
        SimpleOrdine testDestinazione =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        testDestinazione.setDestinazione("ultima");
        assertEquals(testDestinazione.getDestinazione(),"ultima");
        assertNotEquals(testDestinazione.getDestinazione(),"destinazione");
    }

    @Test
    void testGetIdMagazzino() {
        SimpleOrdine testIdMagazzino =
                new SimpleOrdine(0,5,7,"casa",8,6,"postit");

        assertEquals(testIdMagazzino.getIdMagazzino(),8);
        assertNotEquals(testIdMagazzino.getIdCorriere(),5);
    }

    @Test
    void testSetIdMagazzino() {
        SimpleOrdine testIdMagazzino =
                new SimpleOrdine(0,5,7,"casa",8,6,"postit");

        testIdMagazzino.setIdMagazzino(17);
        assertEquals(testIdMagazzino.getIdMagazzino(),17);
        assertNotEquals(testIdMagazzino.getIdMagazzino(),8);
    }

    @Test
    void testGetIdNegozio() {
        SimpleOrdine testIdNegozio =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        assertEquals(testIdNegozio.getIdNegozio(),2);
        assertNotEquals(testIdNegozio.getIdNegozio(),1);
    }

    @Test
    void testSetIdNegozio() {
        SimpleOrdine testIdNegozio =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        testIdNegozio.setIdNegozio(12);
        assertEquals(testIdNegozio.getIdNegozio(),12);
        assertNotEquals(testIdNegozio.getDestinazione(),2);
    }

    @Test
    void testGetNote() {
        SimpleOrdine testNote =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        assertEquals(testNote.getNote(),"note");
        assertNotEquals(testNote.getNote(),"destinazione");
    }

    @Test
    void testSetNote() {
        SimpleOrdine testNote =
                new SimpleOrdine(0,1,3,"destinazione",4,2,"note");

        testNote.setNote("corri");
        assertEquals(testNote.getNote(),"corri");
        assertNotEquals(testNote.getNote(),"note");
    }

    //TODO: test mancanti(generaCodice, getID, setId, getCodiceRitiro, setCodiceRitiro,
    //                    getStatoOrdine, setStatoOrdine)

}