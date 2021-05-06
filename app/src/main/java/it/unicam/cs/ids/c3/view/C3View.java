package it.unicam.cs.ids.c3.view;

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

public class C3View implements Initializable {

    @FXML
    private Button impiegatoButton;

    @FXML
    private Button corriereButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Quando si passa il mouse sopra al bottone, cambia colore.
        impiegatoButton.setOnMouseEntered(e -> impiegatoButton.setStyle("-fx-background-color: DARKGRAY"));
        corriereButton.setOnMouseEntered(e -> corriereButton.setStyle("-fx-background-color: DARKGRAY"));
        impiegatoButton.setOnMouseExited(e -> impiegatoButton.setStyle("-fx-background-color: TRANSPARENT"));
        corriereButton.setOnMouseExited(e -> corriereButton.setStyle("-fx-background-color: TRANSPARENT"));
    }

    @FXML
    void apriMenuImpiegato(ActionEvent event){
        Stage primaryStage = (Stage)impiegatoButton.getScene().getWindow();
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

}

