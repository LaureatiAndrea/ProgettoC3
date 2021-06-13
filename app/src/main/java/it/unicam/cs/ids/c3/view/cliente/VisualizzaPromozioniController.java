package it.unicam.cs.ids.c3.view.cliente;

import it.unicam.cs.ids.c3.negozio.GestoreNegozi;
import it.unicam.cs.ids.c3.negozio.Negozio;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
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

public class VisualizzaPromozioniController implements Initializable {

    private GestoreNegozi gestoreNegozi = GestoreNegozi.getInstance();

    @FXML
    private TableView<Negozio> tableView;

    @FXML
    private TableColumn<Negozio, Double> scontoColumn;

    @FXML
    private TableColumn<Negozio, String> categoriaColumn;

    @FXML
    private TableColumn<Negozio, String> negozioColumn;

    @FXML
    private TableColumn<Negozio, String> indirizzoColumn;

    @FXML
    private Button indietroButton;

    @FXML
    private ChoiceBox<String> filtraCategoriaChoiceBox;

    @FXML
    private TableColumn<Negozio, String> noteColumn;

    @FXML
    void annullaButtonPressed(ActionEvent event) {
        //Deve annullare il processo di prelevamento dell'ordine
        Stage primaryStage = (Stage) indietroButton.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/cliente/InterfacciaCliente.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del cliente");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @FXML
    void filtraButtonPressed(ActionEvent event) {
        //Filtra i negozi nella tabella in accordo con la categoria selezionata nella choicebox
        tableView.setItems(FXCollections.observableArrayList(
                gestoreNegozi.getNegoziConPromozioniByCategoria(filtraCategoriaChoiceBox.getSelectionModel().getSelectedItem())));
        if(tableView.getItems().stream().count()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Non ci sono promozioni attive per la categoria selezionata");
            alert.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO : Mostrare ogni promozione di ogni negozio, non solo una.
        //carica la tabella con tutti i negozi.
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getNegoziConPromozioni()));
        // Colonna promozioni (%Sconto)
        scontoColumn.setCellValueFactory(cella -> {
            return new SimpleDoubleProperty(cella.getValue().getPromozioneAttiva().getPercentualeSconto()).asObject();
        });
        //Colonna negozio (Nome negozio)
        negozioColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getNome());
        });
        //colonna indirizzo (indirizzo negozio)
        indirizzoColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getIndirizzo());
        });
        //colonna categoria (categoria negozio)
        categoriaColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getCategoria().name());
        });
        //colonna note ( note promozione )
        noteColumn.setCellValueFactory(cella -> {
            return new SimpleStringProperty(cella.getValue().getPromozioneAttiva().getNote());
        });
        //Inizializzare la choiceBox
        filtraCategoriaChoiceBox.getItems().setAll(gestoreNegozi.getCategorieAsStrings());
        filtraCategoriaChoiceBox.getSelectionModel().selectFirst();
    }

}
