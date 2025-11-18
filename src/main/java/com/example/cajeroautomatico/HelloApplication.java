package com.example.cajeroautomatico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoaderInicio = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene sceneInicio = new Scene(fxmlLoaderInicio.load(), 320, 240);
        stage.setTitle("BBVA");
        stage.setScene(sceneInicio);
        stage.show();
    }
}