package it.unicam.cs.ids.c3.magazzino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe dei test per SimpleMagazzino.
 */
class SimpleMagazzinoTest {

    @Test
    void testGetId() {
        SimpleMagazzino testIdMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");

        assertEquals(testIdMagazzino.getId(),1);
        assertNotEquals(testIdMagazzino.getId(),2);
    }

    @Test
    void testGetNome() {
        SimpleMagazzino testNomeMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");

        assertEquals(testNomeMagazzino.getNome(),"Centro commerciale X");
        assertNotEquals(testNomeMagazzino.getNome(),"Marco");
    }

    @Test
    void testSetNome() {
        SimpleMagazzino testNomeMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");

        testNomeMagazzino.setNome("Pippo");
        assertEquals("Pippo",testNomeMagazzino.getNome());
    }

    @Test
    void testGetIndirizzo() {
        SimpleMagazzino testIndirizzoMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");

        assertEquals("Via cardo 22", testIndirizzoMagazzino.getIndirizzo());
        assertNotEquals(testIndirizzoMagazzino.getIndirizzo(),"Paperopoli");
    }

    @Test
    void testSetIndirizzo() {
        SimpleMagazzino testIndirizzoMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");

        testIndirizzoMagazzino.setIndirizzo("Paperopoli");
        assertEquals(testIndirizzoMagazzino.getIndirizzo(),"Paperopoli");
        assertNotEquals("Topolinia",testIndirizzoMagazzino.getIndirizzo());
    }

    @Test
    void testEquals() {
        SimpleMagazzino magazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");
        SimpleMagazzino stessoMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");
        SimpleMagazzino magazzino2 =
                new SimpleMagazzino(2, "Magazzino Centrale", "Via P.Fossa 144");
        SimpleMagazzino diversoNome =
                new SimpleMagazzino(2, "diversoNome", "Via P.Fossa 144");
        SimpleMagazzino diversoIndirizzo =
                new SimpleMagazzino(2, "Magazzino Centrale", "diversoIndirizzo");

        assertEquals(magazzino, stessoMagazzino);
        assertNotEquals(magazzino, magazzino2);
        assertNotEquals(magazzino2, diversoNome);
        assertNotEquals(magazzino2, diversoIndirizzo);
    }

    @Test
    void testHashCode() {
        SimpleMagazzino magazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");
        SimpleMagazzino stessoMagazzino =
                new SimpleMagazzino(1, "Centro commerciale X", "Via cardo 22");
        SimpleMagazzino magazzino2 =
                new SimpleMagazzino(2, "Magazzino Centrale", "Via P.Fossa 144");
        SimpleMagazzino diversoNome =
                new SimpleMagazzino(2, "diversoNome", "Via P.Fossa 144");
        SimpleMagazzino diversoIndirizzo =
                new SimpleMagazzino(2, "Magazzino Centrale", "diversoIndirizzo");

        assertEquals(magazzino.hashCode(), stessoMagazzino.hashCode());
        assertNotEquals(magazzino.hashCode(), magazzino2.hashCode());
        assertNotEquals(magazzino2.hashCode(), diversoNome.hashCode());
        assertNotEquals(magazzino2.hashCode(), diversoIndirizzo.hashCode());
    }

}