package it.unicam.cs.ids.c3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Questa classe avvia a tutti gli effetti l'interfaccia grafica dell'applicazione C3.
 * La prima finestra che viene presentata all'utente è quella di Login.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class JavaFxC3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        //Mostra la schermata di Login all'utente.
        loader.setLocation(getClass().getResource("/C3Login.fxml"));
        loader.load();
        Parent parent = loader.getRoot();
        Scene scene = new Scene(parent);
        primaryStage.setTitle("Benvenuto in C3!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.sizeToScene();
    }
}
