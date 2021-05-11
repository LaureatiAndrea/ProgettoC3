package it.unicam.cs.ids.c3.view.corriere;

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

public class ICorriere implements Initializable {

    @FXML
    private Button prelevaOrdineButton;

    @FXML
    private Button consegnaOrdineButton;

    @FXML
    void consegnaOrdine(ActionEvent event) {

    }

    @FXML
    void prelevaOrdine(ActionEvent event) {
        Stage primaryStage = (Stage)prelevaOrdineButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/corriere/PrelevaOrdine.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del corriere");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prelevaOrdineButton.setOnMouseEntered(e -> prelevaOrdineButton.setStyle("-fx-background-color: DARKGRAY"));
        prelevaOrdineButton.setOnMouseExited(e -> prelevaOrdineButton.setStyle("-fx-background-color: TRANSPARENT"));
        consegnaOrdineButton.setOnMouseEntered(e -> consegnaOrdineButton.setStyle("-fx-background-color: DARKGRAY"));
        consegnaOrdineButton.setOnMouseExited(e -> consegnaOrdineButton.setStyle("-fx-background-color: TRANSPARENT"));
    }
}
