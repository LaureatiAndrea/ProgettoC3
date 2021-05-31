package it.unicam.cs.ids.c3.login;

import it.unicam.cs.ids.c3.cliente.GestoreClienti;
import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.database.MySqlDatabase;

/**
 * Questa classe ha la responsabilitá di gestire registrazione e login degli utenti del sistema C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
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

    /**
     * Controlla sul database la corrispondenza dei dati passati come parametro.
     * @param ruolo il ruolo dell'utente che vuole loggarsi
     * @param username l'username utente
     * @param password la password utente
     * @return true se il login va a buon fine, false altrimenti.
     */
    public boolean login(String ruolo, String username, String password) {
        int result = db.login(ruolo, username, password);
        if (result > -1) {
            switch (ruolo) {
                case "CLIENTE":
                    gestoreClienti.setLoggedInUser(gestoreClienti.getCliente(result));
                    System.out.println("id loggato = "+result);
                    return true;
                case "CORRIERE":
                    gestoreCorrieri.setLoggedInUser(gestoreCorrieri.getCorriere(result));
                    System.out.println("id loggato = "+result);
                    return true;
                case "IMPIEGATO":
                    //TODO : Implementare
            }
        }
        return false;
    }
}
