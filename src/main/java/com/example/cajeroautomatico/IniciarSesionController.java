package com.example.cajeroautomatico;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class IniciarSesionController {



    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfPin;

    @FXML
    private void onActionCerrar(){
        Window window = tfNombre.getScene().getWindow();
        if(window instanceof Stage stage){
            stage.close();
        }
    }

    @FXML
    private void onActionIniciarSesion() throws IOException {
        if(RegistrarseController.usuarios.containsKey(tfNombre.getText())){
            Usuario usuario = RegistrarseController.usuarios.get(tfNombre.getText());
            System.out.println("Sesion iniciada con usuario "+usuario.getNombre());
            if(!Objects.equals(usuario.getPin(), tfPin.getText())){
                System.out.println("Pin incorrecto.");
                tfPin.setText(null);
            } else{
                FXMLLoader fxmlLoaderPrincipal = new FXMLLoader(HelloApplication.class.getResource("pantalla_principal.fxml"));
                Stage stagePrincipal = new Stage();
                stagePrincipal.setTitle("Gestor de BBVA");
                stagePrincipal.setMinWidth(420);
                stagePrincipal.setMinHeight(340);
                Parent root = fxmlLoaderPrincipal.load();
                //Con el controlador puedes hacer cualquier cosa dentro de la interfaz
                PrincipalController controller = fxmlLoaderPrincipal.getController();
                controller.setUsuario(usuario);
                Scene scenePrincipal = new Scene(root, 320, 240);
                stagePrincipal.initModality(Modality.APPLICATION_MODAL);
                stagePrincipal.initStyle(StageStyle.UTILITY);
                stagePrincipal.setResizable(false);
                stagePrincipal.setScene(scenePrincipal);
                stagePrincipal.show();
                Window window = tfNombre.getScene().getWindow();
                if (window instanceof Stage stg) {
                    stg.close();
                }
            }
        } else {
            System.out.println("No hay usuario con ese nombre.");
            tfNombre.setText(null);
        }
    }

}
