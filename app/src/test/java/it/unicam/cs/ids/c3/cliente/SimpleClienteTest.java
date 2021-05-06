package it.unicam.cs.ids.c3.cliente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleClienteTest {

    @Test
    void testGetId() {
        SimpleCliente testIdCliente =
                new SimpleCliente(1,"Andrea","Laureati","via roma 6");

        assertEquals(testIdCliente.getId(),1);
        assertNotEquals(testIdCliente.getNome(),34);
    }

    @Test
    void testSetId() {
        SimpleCliente testNomeCliente =
                new SimpleCliente(1,"Marco","Gaetani","via malta 17");

        testNomeCliente.setId(2);
        assertEquals(2,testNomeCliente.getId());
    }

    @Test
    void testGetNome() {
        SimpleCliente testNomeCliente =
                new SimpleCliente(1,"Andrea","Laureati","via roma 6");

        assertEquals(testNomeCliente.getNome(),"Andrea");
        assertNotEquals(testNomeCliente.getNome(),"Marco");
    }

    @Test
    void testSetNome() {
        SimpleCliente testNomeCliente =
                new SimpleCliente(1,"Marco","Gaetani","via malta 17");

        testNomeCliente.setNome("Pippo");
        assertEquals("Pippo",testNomeCliente.getNome());
    }

    @Test
    void testGetCognome(){
        SimpleCliente testCognomeCliente =
                new SimpleCliente(1,"Andrea","Laureati","via roma 6");

        assertEquals(testCognomeCliente.getCognome(),"Laureati");
        assertNotEquals(testCognomeCliente.getCognome(),"Gaetani");
    }

    @Test
    void testSetCognome() {
        SimpleCliente testCognomeCliente =
                new SimpleCliente(1,"Marco","Gaetani","via malta 17");

        testCognomeCliente.setCognome("Superpippo");
        assertEquals("Superpippo",testCognomeCliente.getCognome());
    }

    @Test
    void testGetIndirizzo() {
        SimpleCliente testIndirizzoCliente =
                new SimpleCliente(1,"Mickey","Mouse","Topolinia");

        testIndirizzoCliente.setCognome("Pippo");
        assertEquals(testIndirizzoCliente.getIndirizzo(),"Topolinia");
        assertNotEquals(testIndirizzoCliente.getIndirizzo(),"Paperopoli");
    }

    @Test
    void testSetIndirizzo() {
        SimpleCliente testIndirizzoCliente =
                new SimpleCliente(1,"Marco","Gaetani","topolinia");

        testIndirizzoCliente.setCognome("Paperopoli");
        assertNotEquals("Paperopoli",testIndirizzoCliente.getIndirizzo());
    }

}