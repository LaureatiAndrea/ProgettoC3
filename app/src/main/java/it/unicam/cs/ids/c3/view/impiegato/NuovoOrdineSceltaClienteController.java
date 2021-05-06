package it.unicam.cs.ids.c3.view.impiegato;

import it.unicam.cs.ids.c3.cliente.Cliente;
import it.unicam.cs.ids.c3.cliente.GestoreClienti;
import it.unicam.cs.ids.c3.ordine.GestoreOrdini;
import it.unicam.cs.ids.c3.ordine.Ordine;
import it.unicam.cs.ids.c3.ordine.SimpleOrdine;
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

public class NuovoOrdineSceltaClienteController implements Initializable {

    private static GestoreClienti gestoreClienti = GestoreClienti.getInstance();
    private static GestoreOrdini gestoreOrdini = GestoreOrdini.getInstance();

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private Button annullaButton;

    @FXML
    private Button confermaButton;

    @FXML
    void annullaButtonClicked(MouseEvent event) {
        //Deve annullare il processo di creazione dell'ordine
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
        gestoreOrdini.clearTemp();
    }

    @FXML
    void confermaButtonClicked(MouseEvent event) {
        //Inserisce un ordine con l'id del cliente selezionato
        if(clienteComboBox.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Devi scegliere un cliente");
            alert.show();
        }else {
            gestoreOrdini.setTemp(new SimpleOrdine(clienteComboBox.getValue().getId(), -1, null, -1,null));
            //Gestisce l'apertura della finestra successiva
            Stage primaryStage = (Stage) confermaButton.getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/impiegato/NuovoOrdineSceltaDestinazione.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Impossibile aprire l'interfaccia dell'Impiegato");
            }
            primaryStage.getScene().setRoot(root);
            primaryStage.sizeToScene();
            //Gestire il passaggio dei dati tra finestre
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Deve riempire la combobox con i dati dei clienti da cui scegliere
        for(Cliente c : gestoreClienti.getClienti()){
            clienteComboBox.getItems().add(c);
        }
    }

}
