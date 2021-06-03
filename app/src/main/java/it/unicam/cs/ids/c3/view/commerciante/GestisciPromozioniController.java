package it.unicam.cs.ids.c3.view.commerciante;

import it.unicam.cs.ids.c3.negozio.GestoreNegozi;
import it.unicam.cs.ids.c3.negozio.Promozione;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestisciPromozioniController implements Initializable {

    private GestoreNegozi gestoreNegozi = GestoreNegozi.getInstance();
    private int idNegozio = (gestoreNegozi.getNegozioDelCommerciante(gestoreNegozi.getLoggedInUserId())).getId();

    @FXML
    private TableView<Promozione> tableView;

    @FXML
    private TableColumn<Promozione, String> percScontoColumn;

    @FXML
    private TableColumn<Promozione, String> statoColumn;

    @FXML
    private TableColumn<Promozione, String> noteColumn;

    @FXML
    private Button eliminaPromozione;

    @FXML
    private Button annullaButton;

    @FXML
    private Button aggiungiPromozioneButton;

    @FXML
    private Button disattivaPromozioneButton;

    @FXML
    private Button attivaPromozioneButton;

    @FXML
    private TextField percScontoTextField;

    @FXML
    private DatePicker dataInizioDatePicker;

    @FXML
    private DatePicker dataFineDatePicker;

    @FXML
    private TextField noteTextField;

    @FXML
    private Label label;

    @FXML
    void aggiungiPromozioneButtonClicked(ActionEvent event) {
        double percSconto = Double.parseDouble(percScontoTextField.getText());
        String note = noteTextField.getText();
        gestoreNegozi.aggiungiPromozione(idNegozio, percSconto, note);
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getPromozioniOfNegozio(idNegozio)));
    }

    @FXML
    void annullaButtonPressed(ActionEvent event) {
        Stage primaryStage = (Stage)aggiungiPromozioneButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/commerciante/InterfacciaCommerciante.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del commerciante");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @FXML
    void eliminaPromozioneButtonClicked(ActionEvent event) {
        int idPromozione = tableView.getSelectionModel().getSelectedItem().getId();
        gestoreNegozi.eliminaPromozione(idPromozione);
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    void attivaPromozioneButtonClicked(ActionEvent event) {
        gestoreNegozi.attivaPromozione(tableView.getSelectionModel().getSelectedItem().getId());
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getPromozioniOfNegozio(idNegozio)));
    }

    @FXML
    void disattivaPromozioneButtonClicked(ActionEvent event) {
        gestoreNegozi.disattivaPromozione(tableView.getSelectionModel().getSelectedItem().getId());
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getPromozioniOfNegozio(idNegozio)));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText("Stai gestendo le promozioni del negozio : "+
                (gestoreNegozi.getNegozioDelCommerciante(gestoreNegozi.getLoggedInUserId())).getNome());
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getPromozioniOfNegozio(idNegozio)));
        percScontoColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(String.valueOf(cella.getValue().getPercentualeSconto()));
        });
        statoColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getStatoPromozione() ? "Attiva" : "Non attiva");
        });
        noteColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getNote());
        });
    }
}
