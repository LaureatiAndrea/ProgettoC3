package it.unicam.cs.ids.c3.view.impiegato;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IImpiegato implements Initializable {

    @FXML
    private Button creaNuovoOrdineButton;

    @FXML
    void creaNuovoOrdine(ActionEvent event) {
        Stage primaryStage = (Stage)creaNuovoOrdineButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/impiegato/NuovoOrdineSceltaCliente.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia dell'Impiegato");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        creaNuovoOrdineButton.setOnMouseEntered(e -> creaNuovoOrdineButton.setStyle("-fx-background-color: DARKGRAY"));
        creaNuovoOrdineButton.setOnMouseExited(e -> creaNuovoOrdineButton.setStyle("-fx-background-color: TRANSPARENT"));
    }
}
