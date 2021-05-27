package it.unicam.cs.ids.c3.view.cliente;

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

public class ICliente implements Initializable {

    @FXML
    private Button visualizzaTuttiNegoziButton;

    @FXML
    void visualizzaTuttiNegoziButtonPressed(ActionEvent event) {
        Stage primaryStage = (Stage)visualizzaTuttiNegoziButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/cliente/VisualizzaTuttiNegozi.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia del cliente");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cambia il colore del button on mouse hover.
        visualizzaTuttiNegoziButton.setOnMouseEntered(
                e -> visualizzaTuttiNegoziButton.setStyle("-fx-background-color: DARKGRAY"));
        visualizzaTuttiNegoziButton.setOnMouseExited(
                e -> visualizzaTuttiNegoziButton.setStyle("-fx-background-color: TRANSPARENT"));
    }
}

