package com.example.cajeroautomatico;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class PrincipalController {
    @FXML
    Label labelBienvenido;
    @FXML
    Label lbSaldoActual;
    IniciarSesionController iniciarSesionController;
    Usuario usuario;

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
        labelBienvenido.setText(usuario.getNombre());
        lbSaldoActual.setText(usuario.getSaldo());
    }
//    @FXML
//    private void initialize() {
//
//        if(usuario!=null){
//            labelBienvenido.setText(usuario.getNombre());
//        }
//
//    }

}
