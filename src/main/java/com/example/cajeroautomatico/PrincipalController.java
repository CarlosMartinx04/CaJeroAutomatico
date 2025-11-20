package com.example.cajeroautomatico;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class PrincipalController {

    @FXML private VBox panelExpandido;

    @FXML
    Label labelBienvenido;
    @FXML
    Label lbSaldoActual;
    @FXML
    TextField tfSaldo;

    IniciarSesionController iniciarSesionController;
    Usuario usuario;

    double saldoEntrante;
    double saldoUsuario;


    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
        labelBienvenido.setText(usuario.getNombre());
        lbSaldoActual.setText(usuario.getSaldo());
    }

    @FXML
    public void onActionAgregar(){
        saldoEntrante = Double.parseDouble(tfSaldo.getText());
        saldoUsuario = Double.parseDouble(usuario.getSaldo());
        double saldoNuevo = saldoEntrante+saldoUsuario;
        if (Double.parseDouble(tfSaldo.getText())<=0){
            System.out.println("Escribe una cantidad de dinero superior a 0.");
        } else {
            usuario.setSaldo(saldoEntrante+saldoUsuario);
            System.out.println("Saldo nuevo: "+saldoNuevo);
            lbSaldoActual.setText(String.valueOf(saldoNuevo));
        }
        tfSaldo.setText(null);
    }

    @FXML
    public void onActionRetirar(){
        saldoEntrante = Double.parseDouble(tfSaldo.getText());
        saldoUsuario = Double.parseDouble(usuario.getSaldo());
        double saldoNuevo = saldoEntrante-saldoUsuario;
        if (Double.parseDouble(tfSaldo.getText())>saldoUsuario){
            System.out.println("Saldo de usuario insuficiente");
        } else {
            usuario.setSaldo(saldoUsuario-saldoEntrante);
            System.out.println("Saldo nuevo: "+saldoNuevo);
            lbSaldoActual.setText(String.valueOf(saldoNuevo));
        }
        tfSaldo.setText(null);
    }

    @FXML
    public void onActionTransferir(){
        Window window = tfSaldo.getScene().getWindow();
        if(window instanceof Stage stg){
            stg.setMinHeight(400);
            stg.setMinWidth(400);
            panelExpandido.setVisible(true);
        }
    }

}
