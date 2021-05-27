package it.unicam.cs.ids.c3.view.cliente;

import it.unicam.cs.ids.c3.negozio.GestoreNegozi;
import it.unicam.cs.ids.c3.negozio.Negozio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VisualizzaNegoziController implements Initializable {

    private GestoreNegozi gestoreNegozi = GestoreNegozi.getInstance();

    @FXML
    private TableView<Negozio> tableView;

    @FXML
    private TableColumn<Negozio, String> negozioColumn;

    @FXML
    private TableColumn<Negozio, String> indirizzoColumn;

    @FXML
    private TableColumn<Negozio, String> categoriaColumn;

    @FXML
    private Button indietroButton;

    @FXML
    private ChoiceBox<String> filtraCategoriaChoiceBox;

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
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getNegoziByCategoria(filtraCategoriaChoiceBox.getSelectionModel().getSelectedItem())));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //carica la tabella con tutti i negozi.
        tableView.setItems(FXCollections.observableArrayList(gestoreNegozi.getNegozi()));
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
        //Inizializzare la choiceBox
        filtraCategoriaChoiceBox.getItems().setAll(gestoreNegozi.getCategorieAsStrings());
        filtraCategoriaChoiceBox.getSelectionModel().selectFirst();
    }

}