package com.example.cajeroautomatico;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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

    @FXML
    TextField tfSaldoTransferir;
    @FXML
    TextField tfUsuarioTransferir;
    @FXML
    Button btTransferir;
    @FXML
    private ToggleButton tbExpandir;


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
        } else if(tfSaldo.getText().isEmpty()){
            System.out.println("Escribe un saldo a retirar");
        } else{
            usuario.setSaldo(saldoUsuario-saldoEntrante);
            System.out.println("Saldo nuevo: "+saldoNuevo);
            lbSaldoActual.setText(String.valueOf(saldoNuevo));
        }
        tfSaldo.setText(null);
    }

    @FXML
    public void onActionExpandir() {

        Window window = tfSaldo.getScene().getWindow();

        if (window instanceof Stage stg) {
            if (tbExpandir.isSelected()) {
                stg.setMinHeight(400);
                stg.setMinWidth(400);
                stg.setHeight(400);
                stg.setWidth(400);
                panelExpandido.setVisible(true);

            } else {
                stg.setMinHeight(340);
                stg.setMinWidth(420);
                stg.setHeight(340);
                stg.setWidth(420);
                panelExpandido.setVisible(false);
            }
        }
    }

    @FXML
    public void onActionTransferir(){
        saldoUsuario = Double.parseDouble(usuario.getSaldo());
        Usuario usuarioATransferir;
        double saldoUsuarioATransferir;
        double saldoATransferir = Double.parseDouble(tfSaldoTransferir.getText());

        if(tfUsuarioTransferir.getText().isEmpty()){
            System.out.println("Escribe un usuario.");
        } else if(!RegistrarseController.usuarios.containsKey(tfUsuarioTransferir.getText())){
            System.out.println("Escribe un usuario existente.");
        } else {
            usuarioATransferir = RegistrarseController.usuarios.get(tfUsuarioTransferir.getText());
            if(saldoATransferir<=0){
                System.out.println("Escribe un saldo coherente.");
            } else if(saldoATransferir>saldoUsuario) {
                System.out.println("Saldo insuficiente");
            } else {
                saldoUsuarioATransferir = Double.parseDouble(usuarioATransferir.getSaldo());
                usuarioATransferir.setSaldo(saldoUsuarioATransferir+saldoATransferir);
                usuario.setSaldo(saldoUsuario-saldoATransferir);
                System.out.println("Saldo nuevo: "+usuario.getSaldo());
                lbSaldoActual.setText(String.valueOf(usuario.getSaldo()));
            }
        }

        if (Double.parseDouble(tfSaldoTransferir.getText())<=0){
            System.out.println("Escribe una cantidad de dinero superior a 0.");
        }
        tfSaldo.setText(null);
    }

    public PrincipalController() {
        super();
    }

    @FXML
    public void onActionCerrarSesion(){
        Window window = tfSaldo.getScene().getWindow();

        if (window instanceof Stage stg) {
            stg.close();
        }
    }

}
