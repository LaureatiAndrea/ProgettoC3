package it.unicam.cs.ids.c3.view.corriere;

import it.unicam.cs.ids.c3.corriere.GestoreCorrieri;
import it.unicam.cs.ids.c3.corriere.Stato_Corriere;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SelezionaStatoController {

    private GestoreCorrieri gestoreCorrieri = GestoreCorrieri.getInstance();

    @FXML
    private Button annullaButton;

    @FXML
    private Button confermaButton;

    @FXML
    private RadioButton disponibileRadioButton;

    @FXML
    private RadioButton nonDisponibileRadioButton;

    @FXML
    void annullaButtonClicked(MouseEvent event) {
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
    void confermaButtonClicked(MouseEvent event) {
        //Deve settare lo stato del corriere in base alla scelta effettuata
        //TODO : Deve funzionare con il corriere loggato invece che col parametro
        Alert alert;
        if(disponibileRadioButton.isSelected()){
            gestoreCorrieri.setStatoCorriere(1, Stato_Corriere.DISPONIBILE);
            alert = new Alert(Alert.AlertType.CONFIRMATION,"Stato modificato");
            alert.showAndWait();
        }else if(nonDisponibileRadioButton.isSelected()){
            gestoreCorrieri.setStatoCorriere(1,Stato_Corriere.NON_DISPONIBILE);
            alert = new Alert(Alert.AlertType.CONFIRMATION,"Stato modificato");
            alert.showAndWait();
            annullaButtonClicked(null);
        }else{
            alert = new Alert(Alert.AlertType.ERROR, "Scegli uno stato");
            alert.showAndWait();
        }
    }

    @FXML
    void disponibileRadioButtonClicked(ActionEvent event) {
        nonDisponibileRadioButton.setSelected(false);
    }

    @FXML
    void nonDisponibileRadioButtonClicked(ActionEvent event) {
        disponibileRadioButton.setSelected(false);
    }
}