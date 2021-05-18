package it.unicam.cs.ids.c3.view.impiegato;

import it.unicam.cs.ids.c3.cliente.Cliente;
import it.unicam.cs.ids.c3.corriere.Corriere;
import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NuovoOrdineSceltaCorriereController implements Initializable {

    private static GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();
    private static GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();
    @FXML
    private ComboBox<Corriere> corriereComboBox;

    @FXML
    private Button annullaButton;

    @FXML
    private Button confermaButton;

    @FXML
    void annullaButtonClicked(MouseEvent event) {
        //Deve annullare la creazione dell'ordine
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
        // Deve andare avanti col processo di creazione dell'ordine
        if(corriereComboBox.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Devi scegliere un corriere");
            alert.show();
        }else {
            gestoreOrdini.getTemp().setIdCorriere(corriereComboBox.getValue().getId());
            Stage primaryStage = (Stage) confermaButton.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/impiegato/NuovoOrdineConferma.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Impossibile aprire l'interfaccia dell'Impiegato");
            }
            primaryStage.getScene().setRoot(root);
            primaryStage.sizeToScene();
            // Gestire come passare i dati tra finestre
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Deve inizializzare la combobox con i corrieri disponibili
        for(Corriere c : gestoreCorrieri.getCorrieri()){
            corriereComboBox.getItems().add(c);
        }
    }
}
