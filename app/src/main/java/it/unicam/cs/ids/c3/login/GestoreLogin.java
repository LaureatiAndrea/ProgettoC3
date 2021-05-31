package it.unicam.cs.ids.c3.login;

import it.unicam.cs.ids.c3.cliente.GestoreClienti;
import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.database.MySqlDatabase;

public class GestoreLogin {

    private static GestoreLogin instance;
    private static GestoreClienti gestoreClienti = GestoreClienti.getInstance();
    private static GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();
    private MySqlDatabase db;

    public static GestoreLogin getInstance() {
        if (instance == null) {
            instance = new GestoreLogin();
        }
        return instance;
    }

    private GestoreLogin() {
        db = MySqlDatabase.getInstance();
    }

    public boolean login(String ruolo, String username, String password) {
        int result = db.login(ruolo, username, password);
        if (result > -1) {
            switch (ruolo) {
                case "CLIENTE":
                    gestoreClienti.setLoggedInUser(gestoreClienti.getCliente(result));
                    System.out.println("id = "+result);
                    return true;
                case "CORRIERE":
                    gestoreCorrieri.setLoggedInUser(gestoreCorrieri.getCorriere(result));
                    System.out.println("id = "+result);
                    return true;
                case "IMPIEGATO":
                    //TODO : Implementare
            }
        }
        return false;
    }
}
