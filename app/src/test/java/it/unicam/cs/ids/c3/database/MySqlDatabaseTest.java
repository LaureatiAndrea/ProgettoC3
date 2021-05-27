package it.unicam.cs.ids.c3.database;

import it.unicam.cs.ids.c3.negozio.Negozio;
import it.unicam.cs.ids.c3.negozio.Promozione;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class MySqlDatabaseTest {
    @Test
    void testGetAllNegozi(){
        MySqlDatabase db = MySqlDatabase.getInstance();
        ArrayList<Negozio> negozi = db.getAllNegozi();
        for(Negozio n : negozi){
            for(Promozione p : n.getPromozioni()){
                System.out.println(p);
            }
        }
    }
}