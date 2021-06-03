package it.unicam.cs.ids.c3.view.commerciante;

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

public class ICommerciante implements Initializable {

    @FXML
    private Button gestisciPromozioniButton;

    @FXML
    void gestisciPromozioniButtonPressed(ActionEvent event) {
        Stage primaryStage = (Stage)gestisciPromozioniButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/commerciante/GestisciPromozioni.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del commerciante");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gestisciPromozioniButton.setOnMouseEntered(e -> gestisciPromozioniButton.setStyle("-fx-background-color: DARKGRAY"));
        gestisciPromozioniButton.setOnMouseExited(e -> gestisciPromozioniButton.setStyle("-fx-background-color: TRANSPARENT"));
    }
}
