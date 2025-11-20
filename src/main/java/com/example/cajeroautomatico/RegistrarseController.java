package com.example.cajeroautomatico;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.HashMap;

public class RegistrarseController{

    static HashMap<String, Usuario> usuarios = new HashMap<>();

    @FXML
    private BorderPane bpMain;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfPin;

    @FXML
    private void onActionCerrar(){
        Window ventana = tfPin.getScene().getWindow();
        if (ventana instanceof Stage stg){
            stg.close();
        }
        //HelloController.stageRegistrarse.close();
    }

    @FXML
    private void onActionRegistrar(){
        Usuario usuario = new Usuario(tfNombre.getText(), tfPin.getText(), 0);
        if (!usuarios.containsKey(tfNombre.getText())) {
            usuarios.put(tfNombre.getText(), usuario);
            System.out.println("Usuario "+tfNombre.getText()+" agregado correctamente");
            Window ventana = tfPin.getScene().getWindow();
            if (ventana instanceof Stage stg){
                stg.close();
            }
        }
    }

}
