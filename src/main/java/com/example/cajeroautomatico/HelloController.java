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

    public static Stage stageRegistrarse;

    @FXML
    Label labelBienvenido;

    @FXML
    private void onActionRegistrarse() {
        try {
            FXMLLoader fxmlLoaderRegistrarse = new FXMLLoader(getClass().getResource("registrarse.fxml"));

            stageRegistrarse = new Stage();
            stageRegistrarse.setTitle("Registrate en BBVA");
            stageRegistrarse.setMinWidth(300);
            stageRegistrarse.setMinHeight(200);
            Scene sceneRegistrarse = new Scene(fxmlLoaderRegistrarse.load(), 500, 500);

            stageRegistrarse.initModality(Modality.APPLICATION_MODAL);
            stageRegistrarse.initStyle(StageStyle.UTILITY);
            stageRegistrarse.setResizable(false);
            stageRegistrarse.setScene(sceneRegistrarse);
            stageRegistrarse.show();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onActionCancelar() {
        if (stageRegistrarse != null) {
            stageRegistrarse.close();
            stageRegistrarse = null;
        }
    }


}
