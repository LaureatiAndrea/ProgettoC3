package it.unicam.cs.ids.c3.autenticazione;

import it.unicam.cs.ids.c3.cliente.GestoreClienti;
import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.database.MySqlDatabase;
import it.unicam.cs.ids.c3.impiegato.GestoreImpiegati;
import it.unicam.cs.ids.c3.negozio.GestoreNegozi;

/**
 * Questa classe ha la responsabilitá di gestire registrazione e login degli utenti del sistema C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class GestoreAutenticazione {

    private static GestoreAutenticazione instance;
    private static GestoreClienti gestoreClienti = GestoreClienti.getInstance();
    private static GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();
    private static GestoreImpiegati gestoreImpiegati = GestoreImpiegati.getInstance();
    private static GestoreNegozi gestoreNegozi = GestoreNegozi.getInstance();
    private MySqlDatabase db;

    public static GestoreAutenticazione getInstance() {
        if (instance == null) {
            instance = new GestoreAutenticazione();
        }
        return instance;
    }

    private GestoreAutenticazione() {
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
                    gestoreImpiegati.setLoggedInUser(gestoreImpiegati.getImpiegato(result));
                    System.out.println("id loggato = "+result);
                    return true;
                case "COMMERCIANTE":
                    gestoreNegozi.setLoggedInUserId(result);
                    System.out.println("id loggato = "+result);
                    return true;
            }
        }
        return false;
    }
}
