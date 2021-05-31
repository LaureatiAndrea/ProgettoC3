package it.unicam.cs.ids.c3;

import it.unicam.cs.ids.c3.view.C3View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Questa classe avvia a tutti gli effetti l'interfaccia grafica dell'applicazione C3.
 *
 * @author Laureati Andrea Francesco, Gaetani Marco ( TEAM LAGM )
 */
public class JavaFxC3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Fa partire la prima finestra dell'applicazione.
        FXMLLoader loader = new FXMLLoader();
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
