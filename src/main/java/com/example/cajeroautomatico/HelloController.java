package com.example.cajeroautomatico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloController {

    @FXML
    static Label labelBienvenido;

    @FXML
    private void onActionRegistrarse() throws IOException{

        FXMLLoader fxmlLoaderRegistrarse = new FXMLLoader(getClass().getResource("registrarse.fxml"));
        Stage stageRegistrarse = new Stage();
        stageRegistrarse.setTitle("Registrate en BBVA");
        stageRegistrarse.setMinWidth(300);
        stageRegistrarse.setMinHeight(200);
        Scene sceneRegistrarse = new Scene(fxmlLoaderRegistrarse.load(), 500, 500);

        stageRegistrarse.initModality(Modality.APPLICATION_MODAL);
        stageRegistrarse.initStyle(StageStyle.UTILITY);
        stageRegistrarse.setResizable(false);
        stageRegistrarse.setScene(sceneRegistrarse);
        stageRegistrarse.show();
    }

    @FXML
    private void onActionIniciarSesion() throws IOException {
        FXMLLoader fxmlLoaderIniciarSesion = new FXMLLoader(HelloApplication.class.getResource("iniciar_sesion.fxml"));
        Stage stageIniciarSesion = new Stage();
        stageIniciarSesion.setTitle("Iniciar sesion en BBVA");
        stageIniciarSesion.setMinWidth(300);
        stageIniciarSesion.setMinHeight(200);
        Scene sceneIniciarSesion = new Scene(fxmlLoaderIniciarSesion.load(), 320, 240);
        stageIniciarSesion.initModality(Modality.APPLICATION_MODAL);
        stageIniciarSesion.initStyle(StageStyle.UTILITY);
        stageIniciarSesion.setResizable(false);
        stageIniciarSesion.setScene(sceneIniciarSesion);
        stageIniciarSesion.show();

    }

}
