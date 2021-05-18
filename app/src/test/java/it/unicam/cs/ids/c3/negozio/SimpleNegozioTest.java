package it.unicam.cs.ids.c3.negozio;

import it.unicam.cs.ids.c3.magazzino.SimpleMagazzino;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleNegozioTest {

    @Test
    void testGetId() {
        SimpleNegozio testIdnegozio =
                new SimpleNegozio(1, "Negozio X", "Via cardo 22", Categoria_Merceologica.ALIMENTARI);

        assertEquals(testIdnegozio.getId(),1);
        assertNotEquals(testIdnegozio.getId(),2);
    }

    @Test
    void testSetId() {
        SimpleNegozio testIdNegozio =
                new SimpleNegozio(2, "BelNegozio", "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO);

        testIdNegozio.setId(3);
        assertEquals(testIdNegozio.getId(),3);
        assertNotEquals(testIdNegozio.getId(),2);
    }

    @Test
    void testGetNome() {
        SimpleNegozio testNomenegozio =
                new SimpleNegozio(1, "TIRRENO", "Via cardo 22", Categoria_Merceologica.ALIMENTARI);

        assertEquals(testNomenegozio.getNome(),"TIRRENO");
        assertNotEquals(testNomenegozio.getNome(),"Tirreno");
    }

    @Test
    void testSetNome() {
        SimpleNegozio testNomeNegozio =
                new SimpleNegozio(2, "BelNegozio", "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO);

        testNomeNegozio.setNome("Pippo");
        assertEquals("Pippo",testNomeNegozio.getNome());
    }

    @Test
    void testGetIndirizzo() {
        SimpleNegozio testIndirizzoNegozio =
                new SimpleNegozio(1, "TIRRENO", "Via cardo 22", Categoria_Merceologica.ALIMENTARI);

        assertEquals( testIndirizzoNegozio.getIndirizzo(),"Via cardo 22");
        assertNotEquals(testIndirizzoNegozio.getIndirizzo(),"Via cardo 2");
    }

    @Test
    void testSetIndirizzo() {
        SimpleNegozio testIndirizzoNegozio =
                new SimpleNegozio(2, "BelNegozio", "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO);

        testIndirizzoNegozio.setIndirizzo("Paperopoli");
        assertEquals(testIndirizzoNegozio.getIndirizzo(),"Paperopoli");
        assertNotEquals("Via Milano 5",testIndirizzoNegozio.getIndirizzo());
    }

    @Test
    void testGetCategoria() {
        SimpleNegozio testCategoriaNegozio =
                new SimpleNegozio(1, "TIRRENO", "Via cardo 22", Categoria_Merceologica.ALIMENTARI);

        assertEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ALIMENTARI);
    }

    @Test
    void testSetCategoria() {
        SimpleNegozio testCategoriaNegozio =
                new SimpleNegozio(1, "TIRRENO", "Via cardo 22", Categoria_Merceologica.ALIMENTARI);

        testCategoriaNegozio.setCategoria(Categoria_Merceologica.ELETTRONICA);
        assertEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ELETTRONICA);
        assertNotEquals(testCategoriaNegozio.getCategoria(), Categoria_Merceologica.ALIMENTARI);
    }

    @Test
    void getPromozioni() {
        SimpleNegozio testPromozioniNegozio =
                new SimpleNegozio(2, "BelNegozio", "Via Milano 5", Categoria_Merceologica.ABBIGLIAMENTO);
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

    //TODO: test rimanenti(lanciaPromozione, terminaPromozione, getPromozione, addPromozione,
    //                     removePromozione)

}