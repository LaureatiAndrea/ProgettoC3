package it.unicam.cs.ids.c3.view.corriere;

import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.magazzino.GestoreMagazzini;
import it.unicam.cs.ids.c3.negozio.GestoreNegozi;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import it.unicam.cs.ids.c3.ordine.Ordine;
import it.unicam.cs.ids.c3.ordine.Stato_Ordine;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class PrelevaOrdineController implements Initializable {

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
    private Button confermaButton;

    @FXML
    private Button annullaButton;

    @FXML
    void annullaButtonPressed(ActionEvent event) {
        //Deve annullare il processo di prelevamento dell'ordine
        Stage primaryStage = (Stage)confermaButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/corriere/InterfacciaCorriere.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del corriere");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @FXML
    void confermaButtonPressed(ActionEvent event) {
        //Deve settare lo stato dell'ordine selezionato come TRASPORTO IN CORSO
        try {
            int idOrdine = tableView.getSelectionModel().getSelectedItem().getID();
            gestoreOrdini.setStatoOrdine(idOrdine, Stato_Ordine.TRASPORTO_IN_CORSO);
            gestoreOrdini.updateList();
            tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
        }catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Seleziona un ordine!");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Setta la tabella per ospitare ordini
        //TODO : Deve visualizzare solo gli ordini ancora da prelevare e del corriere loggato
        tableView.setItems(FXCollections.observableArrayList(gestoreOrdini.getOrdiniInNegozio(gestoreCorrieri.getLoggedInUser().getId())));
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
    }
}
