package it.unicam.cs.ids.c3.view.login;


import it.unicam.cs.ids.c3.login.GestoreLogin;
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

public class LoginController implements Initializable {

    private GestoreLogin gestoreLogin = GestoreLogin.getInstance();

    @FXML
    private TextField usernameTextField;

    @FXML
    private ComboBox<String> ruoloComboBox;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    void loginButtonPressed(ActionEvent event) {
        Stage primaryStage;
        Parent root;
        if((usernameTextField.getText().isEmpty())||
                (passwordPasswordField.getText().isEmpty())||
                (ruoloComboBox.getSelectionModel().getSelectedItem()==null)){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Inserisci Username e Password e seleziona un ruolo.");
            alert.showAndWait();
        }else{
            if(gestoreLogin.login(ruoloComboBox.getSelectionModel().getSelectedItem(),usernameTextField.getText(),passwordPasswordField.getText())){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Login eseguito con successo");
                //TODO : Apre la prossima finestra.
                switch(ruoloComboBox.getSelectionModel().getSelectedItem()){
                    case "CLIENTE":
                        primaryStage = (Stage)loginButton.getScene().getWindow();
                        root = null;
                        try{
                            root = FXMLLoader.load(getClass().getResource("/cliente/InterfacciaCliente.fxml"));
                        }catch (IOException e){
                            e.printStackTrace();
                            System.out.println("Impossibile aprire l'interfaccia del corriere");
                        }
                        primaryStage.getScene().setRoot(root);
                        primaryStage.sizeToScene();
                        break;
                    case "CORRIERE" :
                        primaryStage = (Stage)loginButton.getScene().getWindow();
                        root = null;
                        try{
                            root = FXMLLoader.load(getClass().getResource("/corriere/InterfacciaCorriere.fxml"));
                        }catch (IOException e){
                            e.printStackTrace();
                            System.out.println("Impossibile aprire l'interfaccia del corriere");
                        }
                        primaryStage.getScene().setRoot(root);
                        primaryStage.sizeToScene();
                        break;
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Nessun utente trovato.");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ruoloComboBox.getItems().addAll("CLIENTE","CORRIERE","IMPIEGATO");
    }
}
