package it.unicam.cs.ids.c3.view.corriere;

import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.magazzino.GestoreMagazzini;
import it.unicam.cs.ids.c3.negozio.GestoreNegozi;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import it.unicam.cs.ids.c3.ordine.Ordine;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VisualizzaOrdiniController implements Initializable {

    private GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();
    private GestoreMagazzini gestoreMagazzini = GestoreMagazzini.getInstance();
    private GestoreNegozi gestoreNegozi = GestoreNegozi.getInstance();
    private GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();

    @FXML
    private TableView<Ordine> tableView;

    @FXML
    private TableColumn<Ordine, String> negozioColumn;

    @FXML
    private TableColumn<Ordine, String> ritiraPressoColumn;

    @FXML
    private TableColumn<Ordine, String> destinazioneColumn;

    @FXML
    private TableColumn<Ordine, String> noteColumn;

    @FXML
    private TableColumn<Ordine, String>codiceColumn;

    @FXML
    private Button indietroButton;

    @FXML
    private RadioButton daRitirareRadioButton;

    @FXML
    private RadioButton trasportoInCorsoRadioButton;

    @FXML
    private RadioButton depositatoInMagazzinoRadioButton;

    @FXML
    private RadioButton consegnatoAlClienteRadioButton;

    @FXML
    void annullaButtonPressed(ActionEvent event) {
        //Deve annullare il processo di prelevamento dell'ordine
        Stage primaryStage = (Stage) indietroButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/corriere/InterfacciaCorriere.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del corriere");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @FXML
    void consegnatoAlClienteRadioButtonPressed(ActionEvent event) {
        //Disattiva gli altri 3 button
        daRitirareRadioButton.setSelected(false);
        depositatoInMagazzinoRadioButton.setSelected(false);
        trasportoInCorsoRadioButton.setSelected(false);
        //Mostra soltanto gli ordini consegnati al cliente
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdiniConsegnati(gestoreCorrieri.getLoggedInUser().getId())));
    }

    @FXML
    void daRitirareRadioButtonPressed(ActionEvent event) {
        //Disattiva gli altri 3 button
        consegnatoAlClienteRadioButton.setSelected(false);
        depositatoInMagazzinoRadioButton.setSelected(false);
        trasportoInCorsoRadioButton.setSelected(false);
        //Mostra soltanto gli ordini consegnati al cliente
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdiniInNegozio(gestoreCorrieri.getLoggedInUser().getId())));
    }

    @FXML
    void depositatoInMagazzinoRadioButtonPressed(ActionEvent event) {
        //Disattiva gli altri 3 button
        daRitirareRadioButton.setSelected(false);
        consegnatoAlClienteRadioButton.setSelected(false);
        trasportoInCorsoRadioButton.setSelected(false);
        //Mostra soltanto gli ordini consegnati al cliente
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdiniDepositati(gestoreCorrieri.getLoggedInUser().getId())));
    }

    @FXML
    void trasportoInCorsoRadioButtonPressed(ActionEvent event) {
        //Disattiva gli altri 3 button
        daRitirareRadioButton.setSelected(false);
        depositatoInMagazzinoRadioButton.setSelected(false);
        consegnatoAlClienteRadioButton.setSelected(false);
        //Mostra soltanto gli ordini consegnati al cliente
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdiniInViaggio(gestoreCorrieri.getLoggedInUser().getId())));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO : Deve caricare la tabella con tutti gli ordini appartenenti al corriere loggato.
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdini(gestoreCorrieri.getLoggedInUser().getId())));
        //Colonna destinazione ( Indirizzo di consegna )
        destinazioneColumn.setCellValueFactory(cella -> {
            if(cella.getValue().getDestinazione()!=null) return new SimpleStringProperty("Residenza : "
                    + cella.getValue().getDestinazione());
            else{
                return new SimpleStringProperty("Magazzino : "
                        + gestoreMagazzini.getMagazzino(cella.getValue().getIdMagazzino()).getIndirizzo());
            }
        });
        //Colonna Ritira Presso ( Indirizzo negozio )
        ritiraPressoColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(gestoreNegozi.getNegozio(cella.getValue().getIdNegozio()).getIndirizzo());
        });
        //Colonna negozio ( Nome negozio )
        negozioColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(gestoreNegozi.getNegozio(cella.getValue().getIdNegozio()).getNome());
        });
        //Colonna note ( Note ordine )
        noteColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getNote());
        });
        //Colonna codice ( Codice di ritiro dell'ordine )
        codiceColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(String.valueOf(cella.getValue().getCodiceRitiro()));
                }
        );
    }
}