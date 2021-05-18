package it.unicam.cs.ids.c3.view.impiegato;

import it.unicam.cs.ids.c3.magazzino.GestoreMagazzini;
import it.unicam.cs.ids.c3.magazzino.Magazzino;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NuovoOrdineSceltaDestinazioneController implements Initializable {

    private static GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();
    private static GestoreMagazzini gestoreMagazzini = GestoreMagazzini.getInstance();

    @FXML
    private ComboBox<Magazzino> magazzinoComboBox;

    @FXML
    private Button annullaButton;

    @FXML
    private Button confermaButton;

    @FXML
    private RadioButton magazzinoRadioButton;

    @FXML
    private RadioButton residenzaRadioButton;

    @FXML
    private TextField residenzaTextField;

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
        //Deve andare avanti con la creazione dell'ordine
        if(magazzinoRadioButton.isSelected()){
            if(magazzinoComboBox.getSelectionModel().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Devi selezionare un magazzino");
                alert.show();
            }else {
                gestoreOrdini.getTemp().setIdMagazzino(magazzinoComboBox.getValue().getId());
                nextWindow();
            }
        }else{
            if(residenzaTextField.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Devi scrivere un indirizzo");
                alert.show();
            }else {
                gestoreOrdini.getTemp().setDestinazione(residenzaTextField.getText());
                nextWindow();
            }
        }
    }

    void nextWindow(){
        Stage primaryStage = (Stage)confermaButton.getScene().getWindow();
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource("/impiegato/NuovoOrdineSceltaCorriere.fxml"));
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Impossibile aprire l'interfaccia dell'Impiegato");
        }
        primaryStage.getScene().setRoot(root);
        primaryStage.sizeToScene();
    }
    @FXML
    void magazzinoRadioButtonClick(MouseEvent event) {
        //Deve mostrare le opzioni corrispondenti
        residenzaRadioButton.setSelected(false);
        residenzaTextField.setDisable(true);
        residenzaTextField.clear();
        magazzinoComboBox.setDisable(false);
    }

    @FXML
    void residenzaRadioButtonClick(MouseEvent event) {
        //Deve mostrare le opzioni corrispondenti
        magazzinoComboBox.setDisable(true);
        magazzinoRadioButton.setSelected(false);
        residenzaTextField.setDisable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //La combobox del magazzino deve essere inizializzata
        magazzinoRadioButton.setSelected(true);
        residenzaTextField.setDisable(true);

        for(Magazzino m : gestoreMagazzini.getMagazzini()){
            magazzinoComboBox.getItems().add(m);
        }
    }
}
