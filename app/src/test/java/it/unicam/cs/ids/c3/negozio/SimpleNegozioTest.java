package it.unicam.cs.ids.c3.negozio;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe dei test per SimpleNegozio.
 */
class SimpleNegozioTest {

    @Test
    void testGetId() {
        SimpleNegozio testIdnegozio =
                new SimpleNegozio(1, "Negozio X",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI, 3);

        assertEquals(testIdnegozio.getId(),1);
        assertNotEquals(testIdnegozio.getId(),2);
    }

    @Test
    void testSetId() {
        SimpleNegozio testIdNegozio =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO, 4);

        testIdNegozio.setId(3);
        assertEquals(testIdNegozio.getId(),3);
        assertNotEquals(testIdNegozio.getId(),2);
    }

    @Test
    void testGetNome() {
        SimpleNegozio testNomenegozio =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI, 3);

        assertEquals(testNomenegozio.getNome(),"TIRRENO");
        assertNotEquals(testNomenegozio.getNome(),"Tirreno");
    }

    @Test
    void testSetNome() {
        SimpleNegozio testNomeNegozio =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO,4);

        testNomeNegozio.setNome("Pippo");
        assertEquals("Pippo",testNomeNegozio.getNome());
    }

    @Test
    void testGetIndirizzo() {
        SimpleNegozio testIndirizzoNegozio =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,5);

        assertEquals( testIndirizzoNegozio.getIndirizzo(),"Via cardo 22");
        assertNotEquals(testIndirizzoNegozio.getIndirizzo(),"Via cardo 2");
    }

    @Test
    void testSetIndirizzo() {
        SimpleNegozio testIndirizzoNegozio =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO,4);

        testIndirizzoNegozio.setIndirizzo("Paperopoli");
        assertEquals(testIndirizzoNegozio.getIndirizzo(),"Paperopoli");
        assertNotEquals("Via Milano 5",testIndirizzoNegozio.getIndirizzo());
    }

    @Test
    void testGetCategoria() {
        SimpleNegozio testCategoriaNegozio =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,3);

        assertEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ALIMENTARI);
    }

    @Test
    void testSetCategoria() {
        SimpleNegozio testCategoriaNegozio =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,3);

        testCategoriaNegozio.setCategoria(Categoria_Merceologica.ELETTRONICA);
        assertEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ELETTRONICA);
        assertNotEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ALIMENTARI);
    }

    @Test
    void getPromozioni() {
        SimpleNegozio testPromozioniNegozio =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO,4);
        ArrayList<Promozione> promozioni = new ArrayList<>();
        Promozione p1 = new Promozione(1,20.00);
        Promozione p2 = new Promozione(2,10.50);
        Promozione p3 = new Promozione(3,15.50);

        promozioni.add(p1);
        promozioni.add(p2);
        promozioni.add(p3);
        testPromozioniNegozio.addPromozione(p1);
        testPromozioniNegozio.addPromozione(p2);
        testPromozioniNegozio.addPromozione(p3);

        assertEquals(promozioni,testPromozioniNegozio.getPromozioni());
    }

    @Test
    void lanciaPromozione() {
        SimpleNegozio testLanciaPromozione =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,3);
        Promozione p1 = new Promozione(1,20.00);
        p1.setStatoPromozione(false);

        testLanciaPromozione.addPromozione(p1);
        assertEquals(testLanciaPromozione.getPromozione(1).getStatoPromozione(),false);
        testLanciaPromozione.lanciaPromozione(p1);
        assertEquals(testLanciaPromozione.getPromozione(1).getStatoPromozione(),true);
    }

    @Test
    void terminaPromozione() {
        SimpleNegozio testTerminaPromozione =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,3);
        Promozione p2 = new Promozione(2,10.50);

        testTerminaPromozione.addPromozione(p2);
        testTerminaPromozione.terminaPromozione(p2);

        assertEquals(testTerminaPromozione.getPromozione(2).getStatoPromozione(),false);
    }

    @Test
    void getPromozione() {
        SimpleNegozio testPromozione =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO,4);
        Promozione p3 = new Promozione(3,15.50);

        testPromozione.addPromozione(p3);

        assertEquals(testPromozione.getPromozione(3),p3);
    }

    @Test
    void addPromozione() {
        SimpleNegozio testAddPromozione =
                new SimpleNegozio(1, "TIRRENO",
                           "Via cardo 22", Categoria_Merceologica.ALIMENTARI,3);
        Promozione p3 = new Promozione(3,15.50);

        testAddPromozione.addPromozione(p3);

        assertEquals(testAddPromozione.getPromozioni().isEmpty(), false);
        assertEquals(true, testAddPromozione.getPromozioni().contains(p3));
    }

    @Test
    void removePromozione() {
        SimpleNegozio testRemovePromozione =
                new SimpleNegozio(2, "BelNegozio",
                           "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO,4);
        Promozione p1 = new Promozione(1,20.00);

        testRemovePromozione.addPromozione(p1);
        assertEquals(testRemovePromozione.getPromozioni().contains(p1), true);
        testRemovePromozione.removePromozione(p1);
        assertEquals(testRemovePromozione.getPromozioni().contains(p1), false);
    }

}