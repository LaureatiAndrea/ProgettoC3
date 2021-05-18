package it.unicam.cs.ids.c3.view.impiegato;

import it.unicam.cs.ids.c3.cliente.Cliente;
import it.unicam.cs.ids.c3.cliente.GestoreClienti;
import it.unicam.cs.ids.c3.corriere.Corriere;
import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.magazzino.GestoreMagazzini;
import it.unicam.cs.ids.c3.magazzino.Magazzino;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NuovoOrdineConfermaController implements Initializable {

    private static GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();
    private static GestoreClienti gestoreClienti = GestoreClienti.getInstance();
    private static GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();
    private static GestoreMagazzini gestoreMagazzini = GestoreMagazzini.getInstance();

    @FXML
    private Label showClienteLabel;

    @FXML
    private Button annullaButton;

    @FXML
    private Button confermaButton;

    @FXML
    private Label showDestinazioneLabel;

    @FXML
    private Label showCorriereLabel;

    @FXML
    private TextField noteTextField;

    @FXML
    void annullaButtonClicked(MouseEvent event) {
        // Deve tornare alla schermata iniziale
        Stage primaryStage = (Stage)confermaButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/impiegato/InterfacciaImpiegato.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia dell'Impiegato");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @FXML
    void confermaButtonClicked(MouseEvent event) {
        //Deve creare l'ordine a tutti gli effetti
        gestoreOrdini.getTemp().setNote(noteTextField.getText());
        gestoreOrdini.addOrdine(gestoreOrdini.getTemp());
        int codiceRitiro = gestoreOrdini.getTemp().getCodiceRitiro();
        String verifica = gestoreOrdini.getTemp().toString();
        gestoreOrdini.clearTemp();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Codice per il ritiro : " + codiceRitiro);
        alert.show();
        //TODO : remove verifica
        System.out.println(verifica);
        annullaButtonClicked(null);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Deve mettere le lable con i valori giusti
        int idCliente = gestoreOrdini.getTemp().getIdCliente();
        Cliente cliente = gestoreClienti.getCliente(idCliente);
        String toShow = "Cliente : " + cliente.getCognome() + " " + cliente.getNome();
        showClienteLabel.setText(toShow);
        int idCorriere = gestoreOrdini.getTemp().getIdCorriere();
        Corriere corriere = gestoreCorrieri.getCorriere(idCorriere);
        toShow = "Corriere : " + corriere.getCognome() + " " + corriere.getNome();
        showCorriereLabel.setText(toShow);
        if((gestoreOrdini.getTemp().getIdMagazzino() == -1)){
            toShow = gestoreOrdini.getTemp().getDestinazione();
            showDestinazioneLabel.setText("Residenza : "+toShow);
        }else {
            int idMagazzino = gestoreOrdini.getTemp().getIdMagazzino();
            Magazzino magazzino = gestoreMagazzini.getMagazzino(idMagazzino);
            toShow = "Magazzino : " + magazzino.getNome() + " " + magazzino.getIndirizzo();
            showDestinazioneLabel.setText(toShow);
        }
    }
}